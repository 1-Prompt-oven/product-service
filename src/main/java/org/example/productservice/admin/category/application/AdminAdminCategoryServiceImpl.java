package org.example.productservice.admin.category.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.example.productservice.admin.category.dto.in.AddCategoryRequestDto;
import org.example.productservice.admin.category.dto.in.DeleteCategoryRequestDto;
import org.example.productservice.admin.category.dto.in.UpdateCategoryRequestDto;
import org.example.productservice.admin.category.infrastructure.AdminCategoryRepository;
import org.example.productservice.common.domain.Category;
import org.example.productservice.global.common.response.BaseResponseStatus;
import org.example.productservice.global.error.BaseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class AdminAdminCategoryServiceImpl implements AdminCategoryService {
    private final AdminCategoryRepository adminCategoryRepository;
    private final CategoryEventPublisher categoryEventPublisher;


    @Override
    public void addCategory(AddCategoryRequestDto addCategoryRequestDto) {

        if (Boolean.TRUE.equals(adminCategoryRepository.existsByCategoryName(addCategoryRequestDto.getCategoryName()))) {
            throw new BaseException(BaseResponseStatus.DUPLICATE_CATEGORY_NAME);
        }

        Category savedCategory;
        if (addCategoryRequestDto.getParentCategoryUuid().isEmpty()) {
            savedCategory = adminCategoryRepository.save(addCategoryRequestDto.createRootCategory());
        } else {
            Category parentCategory = findCategoryByCategoryUuid(addCategoryRequestDto.getParentCategoryUuid());
            savedCategory = adminCategoryRepository.save(addCategoryRequestDto.createChildCategory(parentCategory));
        }

        // 카테고리 생성 이벤트 발행
        categoryEventPublisher.publishCategoryCreated(savedCategory);
    }

    private Category findCategoryByCategoryUuid(String categoryUuid) {
        return adminCategoryRepository.findByCategoryUuid(categoryUuid)
            .orElseThrow(() -> new BaseException(BaseResponseStatus.CATEGORY_NOT_FOUND));
    }

    @Override
    public void updateCategory(UpdateCategoryRequestDto updateCategoryRequestDto) {
        Long categoryId = adminCategoryRepository.findByCategoryUuid(updateCategoryRequestDto.getCategoryUuid())
            .orElseThrow(() -> new BaseException(BaseResponseStatus.CATEGORY_NOT_FOUND))
            .getId();

        adminCategoryRepository.save(updateCategoryRequestDto.toEntity(categoryId));
    }

    @Override
    public void deleteCategory(DeleteCategoryRequestDto deleteCategoryRequestDto) {
        Category category = adminCategoryRepository.findByCategoryUuid(deleteCategoryRequestDto.getCategoryUuid())
            .orElseThrow(() -> new BaseException(BaseResponseStatus.CATEGORY_NOT_FOUND));

        adminCategoryRepository.save(DeleteCategoryRequestDto.toEntity(category));

        //TODO: Delete all products under this category
    }

    @Override
    public void addCategoryFromFile(MultipartFile file) {
        try (BufferedReader br = new BufferedReader(
            new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {

            // Read and process header line to get main category names
            String headerLine = br.readLine();
            if (headerLine == null) return;

            String[] mainCategories = headerLine.split(",");
            Map<Integer, String> columnToMainCategoryUuid = new HashMap<>();

            // Create main categories (코딩, 문서, 그림, 음악)
            for (int i = 0; i < mainCategories.length; i++) {
                String mainCategoryName = mainCategories[i].trim();
                if (mainCategoryName.isEmpty()) continue;

                // Create or get main category
                if (!adminCategoryRepository.existsByCategoryName(mainCategoryName)) {
                    AddCategoryRequestDto requestDto = AddCategoryRequestDto.builder()
                        .categoryName(mainCategoryName)
                        .parentCategoryUuid(null)  // Root categories have null parent
                        .build();

                    Category mainCategory = requestDto.createRootCategory();
                    adminCategoryRepository.save(mainCategory);
                    columnToMainCategoryUuid.put(i, mainCategory.getCategoryUuid());
                } else {
                    Category existingCategory = adminCategoryRepository.findByCategoryName(mainCategoryName)
                        .orElseThrow(() -> new BaseException(BaseResponseStatus.CATEGORY_NOT_FOUND));
                    columnToMainCategoryUuid.put(i, existingCategory.getCategoryUuid());
                }
            }

            // Process each line for sub-categories
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] columns = line.split(",");
                // Process each column's value as a sub-category
                for (int i = 0; i < columns.length; i++) {
                    String subCategoryName = columns[i].trim();
                    if (subCategoryName.isEmpty() ||
                        subCategoryName.equalsIgnoreCase("ETC")) continue;

                    String parentUuid = columnToMainCategoryUuid.get(i);
                    if (parentUuid == null) continue;

                    // Skip if this sub-category already exists
                    if (adminCategoryRepository.existsByCategoryName(subCategoryName)) continue;

                    // Create sub-category with parent UUID
                    Category subCategory = Category.builder()
                        .categoryName(subCategoryName)
                        .categoryUuid("CT-" + UUID.randomUUID().toString().substring(0, 8))
                        .parentCategoryUuid(parentUuid)
                        .depth(1)
                        .build();

                    adminCategoryRepository.save(subCategory);
                }
            }

        } catch (IOException e) {
            throw new BaseException(BaseResponseStatus.FILE_PROCESSING_ERROR);
        }
    }
}
