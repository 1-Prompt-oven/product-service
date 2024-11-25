package org.example.productservice.category.application;

import java.util.List;

import org.example.productservice.category.dto.out.GetSubCategoriesResponseDto;

public interface CategoryService {

    List<GetSubCategoriesResponseDto> getSubCategories(String parentCategoryCode);
}