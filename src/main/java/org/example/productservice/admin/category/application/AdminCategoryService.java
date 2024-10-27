package org.example.productservice.admin.category.application;

import org.example.productservice.admin.category.dto.in.AddCategoryRequestDto;
import org.example.productservice.admin.category.dto.in.DeleteCategoryRequestDto;
import org.example.productservice.admin.category.dto.in.UpdateCategoryRequestDto;
import org.springframework.web.multipart.MultipartFile;

public interface AdminCategoryService {
    void addCategory(AddCategoryRequestDto addCategoryRequestDto);
    void addCategoryFromFile(MultipartFile file);
    void updateCategory(UpdateCategoryRequestDto updateCategoryRequestDto);
    void deleteCategory(DeleteCategoryRequestDto deleteCategoryRequestDto);
}