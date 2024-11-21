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
			.productName(product.getProductName())
			.productUuid(product.getProductUuid())
			.enabled(true)
			.deleted(true)
			.description(product.getDescription())
			.price(product.getPrice())
			.seed(product.getSeed())
			.llmId(product.getLlmId())
			.topCategoryUuid(product.getTopCategoryUuid())
			.subCategoryUuid(product.getSubCategoryUuid())
			.contents(product.getContents())
			.discountRate(product.getDiscountRate())
			.llmVersionId(product.getLlmVersionId())
			.sellerUuid(product.getSellerUuid())
			.prompt(product.getPrompt())
			.approved(product.isApproved())
			.build();
	}
}
