package org.example.productservice.member.category.application;

import java.util.List;

import org.example.productservice.member.category.dto.out.GetSubCategoriesResponseDto;

public interface CategoryService {
	List<GetSubCategoriesResponseDto> getSubCategories(String parentCategoryCode);
}
