package org.example.productservice.seller.product.dto;

import org.example.productservice.common.product.domain.ProductPolicy;
import org.example.productservice.seller.product.vo.UpdateProductPolicyRequestVo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateProductPolicyRequestDto {

	private String productPolicyUuid;
	private String productUuid;
	private float discountRate;
	private boolean enabled;
	private boolean approved;
	private Long llmId;
	private String llmName;

	public static UpdateProductPolicyRequestDto toDto(UpdateProductPolicyRequestVo updateProductPolicyRequestVo) {
		return UpdateProductPolicyRequestDto.builder()
			.productPolicyUuid(updateProductPolicyRequestVo.getProductPolicyUuid())
			.productUuid(updateProductPolicyRequestVo.getProductUuid())
			.discountRate(updateProductPolicyRequestVo.getDiscountRate())
			.enabled(updateProductPolicyRequestVo.isEnabled())
			.approved(updateProductPolicyRequestVo.isApproved())
			.llmId(updateProductPolicyRequestVo.getLlmId())
			.llmName(updateProductPolicyRequestVo.getLlmName())
			.build();
	}

	public ProductPolicy updateProductPolicy(Long productPolicyId) {
		return ProductPolicy.builder()
			.productPolicyId(productPolicyId)
			.productPolicyUuid(productPolicyUuid)
			.productUuid(productUuid)
			.discountRate(discountRate)
			.enabled(enabled)
			.approved(approved)
			.llmId(llmId)
			.llmName(llmName)
			.build();
	}
}
