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
public class ProductEventDto {

	private Long productId;
	private String productUuid;
	private String sellerUuid;
	private String productName;
	private double price;
	private String prompt;
	private String description;
	private Long llmId;
	private String topCategoryUuid;
	private String subCategoryUuid;
	private boolean deleted;

	public static ProductEventDto toDto(Product product) {

		return ProductEventDto.builder()
			.productUuid(product.getProductUuid())
			.sellerUuid(product.getSellerUuid())
			.productName(product.getProductName())
			.price(product.getPrice())
			.prompt(product.getPrompt())
			.description(product.getDescription())
			.llmId(product.getLlmId())
			.topCategoryUuid(product.getTopCategoryUuid())
			.subCategoryUuid(product.getSubCategoryUuid())
			.deleted(product.isDeleted())
			.build();
	}
}
