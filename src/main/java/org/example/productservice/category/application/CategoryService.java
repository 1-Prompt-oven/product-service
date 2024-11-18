package org.example.productservice.category.application;

import java.util.List;

import org.example.productservice.category.dto.in.AddCategoryRequestDto;
import org.example.productservice.category.dto.in.DeleteCategoryRequestDto;
import org.example.productservice.category.dto.in.UpdateCategoryRequestDto;
import org.example.productservice.category.dto.out.GetSubCategoriesResponseDto;

public interface CategoryService {
    void addCategory(AddCategoryRequestDto addCategoryRequestDto);
    void updateCategory(UpdateCategoryRequestDto updateCategoryRequestDto);
    void deleteCategory(DeleteCategoryRequestDto deleteCategoryRequestDto);

    List<GetSubCategoriesResponseDto> getSubCategories(String parentCategoryCode);
}