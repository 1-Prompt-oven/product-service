package org.example.productservice.seller.product.dto.in;

import org.example.productservice.common.domain.ProductPolicy;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class DeleteProductRequestDto {

	private String productUuid;

	public DeleteProductRequestDto(String productUuid) {
		this.productUuid = productUuid;
	}

	public ProductPolicy deleteProduct(ProductPolicy productPolicy) {
		return ProductPolicy.builder()
			.productPolicyId(productPolicy.getProductPolicyId())
			.discountRate(productPolicy.getDiscountRate())
			.enabled(productPolicy.isEnabled())
			.premium(productPolicy.isPremium())
			.thumbnailSrc(productPolicy.getThumbnailSrc())
			.llmId(productPolicy.getLlmId())
			.approved(productPolicy.isApproved())
			.deleted(true)
			.build();
	}
}
