package org.example.productservice.admin.category.event;

import org.example.productservice.common.category.domain.Category;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategoryCreatedEvent {

	private String categoryName;
	private String parentCategoryUuid;

	@Builder
	public CategoryCreatedEvent(String categoryName, String parentCategoryUuid) {
		this.categoryName = categoryName;
		this.parentCategoryUuid = parentCategoryUuid;
	}

	public static CategoryCreatedEvent from(Category category) {
		return CategoryCreatedEvent.builder()
			.categoryName(category.getCategoryName())
			.parentCategoryUuid(category.getParentCategoryUuid() != null ?
				category.getParentCategoryUuid() : "")
			.build();
	}
}
