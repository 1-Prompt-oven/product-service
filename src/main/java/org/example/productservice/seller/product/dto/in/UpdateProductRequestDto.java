package org.example.productservice.seller.product.dto.in;

import org.example.productservice.common.product.domain.Product;
import org.example.productservice.seller.product.vo.in.UpdateProductRequestVo;

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

	private String sellerUuid;

	private String sellerName;

	private int price;

	private String productName;

	private String prompt;

	private String description;

	private float discountRate;

	private boolean enabled;

	private String thumbnailSrc;

	private boolean approved;

	private Long llmId;

	private String llmName;

	public static UpdateProductRequestDto toDto(UpdateProductRequestVo updateProductRequestVo) {
		return UpdateProductRequestDto.builder()
			.productUuid(updateProductRequestVo.getProductUuid())
			.sellerUuid(updateProductRequestVo.getSellerUuid())
			.sellerName(updateProductRequestVo.getSellerName())
			.price(updateProductRequestVo.getPrice())
			.productName(updateProductRequestVo.getProductName())
			.prompt(updateProductRequestVo.getPrompt())
			.description(updateProductRequestVo.getDescription())
			.llmId(updateProductRequestVo.getLlmId())
			.llmName(updateProductRequestVo.getLlmName())
			.build();
	}

	public Product updateProduct(Long productId) {
		return Product.builder()
			.productId(productId)
			.productUuid(productUuid)
			.sellerName(sellerName)
			.sellerUuid(sellerUuid)
			.productName(productName)
			.price(price)
			.prompt(prompt)
			.description(description)
			.llmId(llmId)
			.llmName(llmName)
			.build();
	}

}
