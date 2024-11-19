package org.example.productservice.category.dto.message;

import org.example.productservice.category.domain.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AddCategoryEventDto {

	private String categoryName;
	private String parentCategoryUuid;

	public static AddCategoryEventDto toDto(Category category) {
		return AddCategoryEventDto.builder()
			.categoryName(category.getCategoryName())
			.parentCategoryUuid(category.getParentCategoryUuid() != null ?
				category.getParentCategoryUuid() : "")
			.build();
	}
}
