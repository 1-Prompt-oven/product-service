package org.example.productservice.product.dto.out;

import org.example.productservice.product.domain.Product;
import org.example.productservice.product.vo.out.GetProductDetailResponseVo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class GetProductDetailResponseDto {

	private String productUuid;

	private String sellerUuid;

	private String productName;

	private double price;

	private String prompt;

	private String description;

	private Long llmId;

	private String topCategoryUuid;

	private String subCategoryUuid;

	public static GetProductDetailResponseDto toDto(Product product) {
		return GetProductDetailResponseDto.builder()
			.productUuid(product.getProductUuid())
			.sellerUuid(product.getSellerUuid())
			.price(product.getPrice())
			.prompt(product.getPrompt())
			.productName(product.getProductName())
			.description(product.getDescription())
			.llmId(product.getLlmId())
			.topCategoryUuid(product.getTopCategoryUuid())
			.subCategoryUuid(product.getSubCategoryUuid())
			.build();
	}

	public GetProductDetailResponseVo toVo() {
		return GetProductDetailResponseVo.builder()
			.productUuid(productUuid)
			.sellerUuid(sellerUuid)
			.price(price)
			.prompt(prompt)
			.productName(productName)
			.description(description)
			.llmId(llmId)
			.topCategoryUuid(topCategoryUuid)
			.subCategoryUuid(subCategoryUuid)
			.build();
	}
}
