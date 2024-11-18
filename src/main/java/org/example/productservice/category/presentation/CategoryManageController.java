package org.example.productservice.category.presentation;

import org.example.productservice.category.application.CategoryFileProcessor;
import org.example.productservice.category.application.CategoryService;
import org.example.productservice.category.dto.in.DeleteCategoryRequestDto;
import org.example.productservice.category.dto.in.UpdateCategoryRequestDto;
import org.example.productservice.category.vo.in.AddCategoryRequestVo;
import org.example.productservice.category.vo.in.DeleteCategoryRequestVo;
import org.example.productservice.category.vo.in.UpdateCategoryRequestVo;
import org.example.productservice.common.response.BaseResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@Tag(name = "카테고리 관리 API", description = "카테고리 관련 API endpoints")
@RequestMapping("/v1/admin/category")
public class CategoryManageController {

	private final CategoryService categoryService;
	private final CategoryFileProcessor categoryFileProcessor;

	@Operation(summary = "카테고리 생성", description = "parentCategoryCode =\"\"입력시 최상위 카테고리 생성")
	@PostMapping
	public BaseResponse<Void> addCategory(
		@RequestBody AddCategoryRequestVo addCategoryRequestVo) {

		categoryService.addCategory(addCategoryRequestVo.toDto(addCategoryRequestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "카테고리 수정", description = "카테고리 수정")
	@PutMapping
	public BaseResponse<Void> updateCategory(
		@RequestBody UpdateCategoryRequestVo updateCategoryRequestVo) {
		categoryService.updateCategory(UpdateCategoryRequestDto.toDto(updateCategoryRequestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "카테고리 삭제", description = "카테고리 삭제")
	@DeleteMapping
	public BaseResponse<Void> deleteCategory(
		@RequestBody DeleteCategoryRequestVo deleteCategoryRequestVo) {
		categoryService.deleteCategory(DeleteCategoryRequestDto.toDto(deleteCategoryRequestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "CSV 파일 기반으로 카테고리 생성")
	@PostMapping(value = "/csv", consumes = "multipart/form-data")
	public BaseResponse<Void> addCategoryFromFile(@RequestPart("file") MultipartFile file) {
		categoryFileProcessor.addCategoryFromFile(file);
		return new BaseResponse<>();
	}
}