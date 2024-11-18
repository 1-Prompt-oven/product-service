package org.example.productservice.category.dto.in;

import org.example.productservice.category.domain.Category;
import org.example.productservice.category.vo.in.DeleteCategoryRequestVo;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteCategoryRequestDto {

	private String categoryUuid;

	public DeleteCategoryRequestDto(String categoryUuid) {
		this.categoryUuid = categoryUuid;
	}

	public static Category toEntity(Category category) {
		return Category.builder()
				.id(category.getId())
				.categoryUuid(category.getCategoryUuid())
				.parentCategoryUuid(category.getParentCategoryUuid())
				.categoryName(category.getCategoryName())
				.depth(category.getDepth())
				.deleted(true)
				.build();
	}

	public static DeleteCategoryRequestDto toDto(DeleteCategoryRequestVo deleteCategoryRequestVo) {
		return new DeleteCategoryRequestDto(deleteCategoryRequestVo.getCategoryUuid());
	}
}
