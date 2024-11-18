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

	private String sellerName;

	private String productName;

	private int price;

	private String prompt;

	private String description;

	private Long llmId;

	private String llmName;

	private String topCategoryUuid;

	private String topCategoryName;

	private String subCategoryUuid;

	private String subCategoryName;

	public static GetProductDetailResponseDto toDto(Product product) {
		return GetProductDetailResponseDto.builder()
			.productUuid(product.getProductUuid())
			.sellerUuid(product.getSellerUuid())
			.sellerName(product.getSellerName())
			.price(product.getPrice())
			.prompt(product.getPrompt())
			.productName(product.getProductName())
			.description(product.getDescription())
			.llmId(product.getLlmId())
			.llmName(product.getLlmName())
			.topCategoryUuid(product.getTopCategoryUuid())
			.topCategoryName(product.getTopCategoryName())
			.subCategoryUuid(product.getSubCategoryUuid())
			.subCategoryName(product.getSubCategoryName())
			.build();
	}

	public GetProductDetailResponseVo toVo() {
		return GetProductDetailResponseVo.builder()
			.productUuid(productUuid)
			.sellerUuid(sellerUuid)
			.sellerName(sellerName)
			.price(price)
			.prompt(prompt)
			.productName(productName)
			.description(description)
			.llmId(llmId)
			.llmName(llmName)
			.topCategoryUuid(topCategoryUuid)
			.topCategoryName(topCategoryName)
			.subCategoryUuid(subCategoryUuid)
			.subCategoryName(subCategoryName)
			.build();
	}
}
