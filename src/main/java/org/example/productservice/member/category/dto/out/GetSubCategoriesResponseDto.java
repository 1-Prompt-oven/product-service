package org.example.productservice.member.category.dto.out;

import org.example.productservice.common.domain.Category;
import org.example.productservice.member.category.vo.out.GetSubCategoriesResponseVo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetSubCategoriesResponseDto {

	private String categoryName;
	private String categoryUuid;

	@Builder
	public GetSubCategoriesResponseDto(String categoryName, String categoryUuid) {
		this.categoryName = categoryName;
		this.categoryUuid = categoryUuid;
	}

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
