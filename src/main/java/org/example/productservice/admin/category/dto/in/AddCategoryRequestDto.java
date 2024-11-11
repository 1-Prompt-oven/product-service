package org.example.productservice.admin.category.dto.in;

import org.example.productservice.common.category.domain.Category;
import org.example.productservice.global.common.UuidGenerator;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddCategoryRequestDto {
	private String categoryName;
	private String parentCategoryUuid;

	@Builder
	public AddCategoryRequestDto(String categoryName, String parentCategoryUuid) {
		this.categoryName = categoryName;
		this.parentCategoryUuid = parentCategoryUuid;
	}

	public Category createRootCategory() {
		return Category.builder()
			.categoryName(categoryName)
			.categoryUuid(UuidGenerator.generateCategoryUuid())
			.depth(0)
			.parentCategoryUuid(null)
			.build();
	}

	public Category createChildCategory(Category parentCategory) {
		return Category.builder()
			.categoryName(categoryName)
			.categoryUuid(UuidGenerator.generateCategoryUuid())
			.parentCategoryUuid(parentCategory.getCategoryUuid())
			.depth(parentCategory.getDepth() + 1)
			.build();
	}
}