package org.example.productservice.category.application;

import java.util.List;

import org.example.productservice.category.dto.out.GetSubCategoriesResponseDto;
import org.example.productservice.category.infrastructure.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    @Override
    public List<GetSubCategoriesResponseDto> getSubCategories(String parentCategoryUuid) {

        return categoryRepository.findByParentCategoryUuid(parentCategoryUuid)
            .stream()
            .map(GetSubCategoriesResponseDto::from)
            .toList();
    }
}
