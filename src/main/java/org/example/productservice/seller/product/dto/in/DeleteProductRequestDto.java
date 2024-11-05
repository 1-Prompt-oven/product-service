package org.example.productservice.seller.product.dto.in;

import org.example.productservice.common.domain.ProductPolicy;
import org.example.productservice.seller.product.vo.in.DeleteProductRequestVo;

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

	public ProductPolicy deleteProduct(ProductPolicy productPolicy) {
		return ProductPolicy.builder()
			.productPolicyId(productPolicy.getProductPolicyId())
			.productUuid(productPolicy.getProductUuid())
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
