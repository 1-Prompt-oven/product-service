package org.example.productservice.category.dto.out;

import org.example.productservice.category.domain.Category;
import org.example.productservice.category.vo.out.GetSubCategoriesResponseVo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class GetSubCategoriesResponseDto {

	private String categoryName;
	private String categoryUuid;

	public static GetSubCategoriesResponseDto from(Category category) {
		return GetSubCategoriesResponseDto.builder()
			.categoryUuid(category.getCategoryUuid())
			.categoryName(category.getCategoryName())
			.build();
	}

	public static GetSubCategoriesResponseVo toVo(GetSubCategoriesResponseDto getSubCategoriesResponseDto) {
		return GetSubCategoriesResponseVo.builder()
			.categoryUuid(getSubCategoriesResponseDto.getCategoryUuid())
			.categoryName(getSubCategoriesResponseDto.getCategoryName())
			.build();
	}
}
