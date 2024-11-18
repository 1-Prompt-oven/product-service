package org.example.productservice.category.application;

import java.util.List;

import org.example.productservice.category.domain.Category;
import org.example.productservice.category.dto.in.AddCategoryRequestDto;
import org.example.productservice.category.dto.in.DeleteCategoryRequestDto;
import org.example.productservice.category.dto.in.UpdateCategoryRequestDto;
import org.example.productservice.category.dto.out.GetSubCategoriesResponseDto;
import org.example.productservice.category.infrastructure.CategoryRepository;
import org.example.productservice.category.kafka.publisher.CategoryEventPublisher;
import org.example.productservice.common.error.BaseException;
import org.example.productservice.common.response.BaseResponseStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryEventPublisher categoryEventPublisher;


    @Override
    public void addCategory(AddCategoryRequestDto addCategoryRequestDto) {

        if (Boolean.TRUE.equals(categoryRepository.existsByCategoryName(addCategoryRequestDto.getCategoryName()))) {
            throw new BaseException(BaseResponseStatus.DUPLICATE_CATEGORY_NAME);
        }

        Category savedCategory;
        if (addCategoryRequestDto.getParentCategoryUuid().isEmpty()) {
            savedCategory = categoryRepository.save(addCategoryRequestDto.createRootCategory());

        } else {

            Category parentCategory = findCategoryByCategoryUuid(addCategoryRequestDto.getParentCategoryUuid());
            savedCategory = categoryRepository.save(addCategoryRequestDto.createChildCategory(parentCategory));
        }

        // 카테고리 생성 이벤트 발행
        categoryEventPublisher.publishCategoryCreated(savedCategory);
    }

    private Category findCategoryByCategoryUuid(String categoryUuid) {
        return categoryRepository.findByCategoryUuid(categoryUuid)
            .orElseThrow(() -> new BaseException(BaseResponseStatus.CATEGORY_NOT_FOUND));
    }

    @Override
    public void updateCategory(UpdateCategoryRequestDto updateCategoryRequestDto) {
        Long categoryId = categoryRepository.findByCategoryUuid(updateCategoryRequestDto.getCategoryUuid())
            .orElseThrow(() -> new BaseException(BaseResponseStatus.CATEGORY_NOT_FOUND))
            .getId();

        categoryRepository.save(updateCategoryRequestDto.toEntity(categoryId));
    }

    @Override
    public void deleteCategory(DeleteCategoryRequestDto deleteCategoryRequestDto) {
        Category category = categoryRepository.findByCategoryUuid(deleteCategoryRequestDto.getCategoryUuid())
            .orElseThrow(() -> new BaseException(BaseResponseStatus.CATEGORY_NOT_FOUND));

        categoryRepository.save(DeleteCategoryRequestDto.toEntity(category));

        //TODO: Delete all products under this category
    }

    @Transactional(readOnly = true)
    @Override
    public List<GetSubCategoriesResponseDto> getSubCategories(String parentCategoryUuid) {

        return categoryRepository.findByParentCategoryUuid(parentCategoryUuid)
            .stream()
            .map(GetSubCategoriesResponseDto::from)
            .toList();
    }
}
