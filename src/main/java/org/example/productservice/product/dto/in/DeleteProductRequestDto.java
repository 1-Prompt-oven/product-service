package org.example.productservice.product.dto.in;

import org.example.productservice.product.domain.Product;
import org.example.productservice.product.vo.in.DeleteProductRequestVo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class DeleteProductRequestDto {

	private String productUuid;


	public static DeleteProductRequestDto toDto(DeleteProductRequestVo deleteProductRequestVo) {
		return DeleteProductRequestDto.builder()
			.productUuid(deleteProductRequestVo.getProductUuid())
			.build();
	}

	public Product deleteProduct(Product product) {
		return Product.builder()
			.productId(product.getProductId())
			.productUuid(product.getProductUuid())
			.sellerUuid(product.getSellerUuid())
			.price(product.getPrice())
			.productName(product.getProductName())
			.prompt(product.getPrompt())
			.description(product.getDescription())
			.llmId(product.getLlmId())
			.topCategoryUuid(product.getTopCategoryUuid())
			.subCategoryUuid(product.getSubCategoryUuid())
			.deleted(true)
			.build();
	}
}
