package org.example.productservice.product.dto.message;

import org.example.productservice.product.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class AddProductEventDto {

	private Long productId;
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
	private boolean deleted;

	public static AddProductEventDto toDto(Product product) {

		return AddProductEventDto.builder()
			.productId(product.getProductId())
			.productUuid(product.getProductUuid())
			.sellerUuid(product.getSellerUuid())
			.sellerName(product.getSellerName())
			.productName(product.getProductName())
			.price(product.getPrice())
			.prompt(product.getPrompt())
			.description(product.getDescription())
			.llmId(product.getLlmId())
			.llmName(product.getLlmName())
			.topCategoryUuid(product.getTopCategoryUuid())
			.topCategoryName(product.getTopCategoryName())
			.subCategoryUuid(product.getSubCategoryUuid())
			.subCategoryName(product.getSubCategoryName())
			.deleted(product.isDeleted())
			.build();
	}
}
