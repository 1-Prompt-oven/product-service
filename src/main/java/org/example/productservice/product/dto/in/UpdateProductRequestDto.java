package org.example.productservice.product.dto.in;

import org.example.productservice.product.domain.Product;
import org.example.productservice.product.vo.in.UpdateProductRequestVo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class UpdateProductRequestDto {

	private String productUuid;
	private int price;
	private String productName;
	private String prompt;
	private String description;
	private Long llmId;
	private String topCategoryUuid;
	private String subCategoryUuid;


	public static UpdateProductRequestDto toDto(UpdateProductRequestVo updateProductRequestVo) {
		return UpdateProductRequestDto.builder()
			.productUuid(updateProductRequestVo.getProductUuid())
			.price(updateProductRequestVo.getPrice())
			.productName(updateProductRequestVo.getProductName())
			.prompt(updateProductRequestVo.getPrompt())
			.description(updateProductRequestVo.getDescription())
			.llmId(updateProductRequestVo.getLlmId())
			.topCategoryUuid(updateProductRequestVo.getTopCategoryUuid())
			.subCategoryUuid(updateProductRequestVo.getSubCategoryUuid())
			.build();
	}

	public Product updateProduct(Product product, UpdateProductRequestDto updateProductRequestDto) {
		return Product.builder()
			.productId(product.getProductId())
			.productUuid(product.getProductUuid())
			.sellerUuid(product.getSellerUuid())
			.productName(updateProductRequestDto.getProductName())
			.price(updateProductRequestDto.getPrice())
			.prompt(updateProductRequestDto.getPrompt())
			.description(updateProductRequestDto.getDescription())
			.llmId(updateProductRequestDto.getLlmId())
			.topCategoryUuid(updateProductRequestDto.getTopCategoryUuid())
			.subCategoryUuid(updateProductRequestDto.getSubCategoryUuid())
			.deleted(product.isDeleted())
			.build();
	}

}
