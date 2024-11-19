package org.example.productservice.product.dto;

import org.example.productservice.product.domain.ProductPolicy;
import org.example.productservice.product.vo.UpdateProductPolicyRequestVo;

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
	private String seed;
	private Long llmVersionId;

	public static UpdateProductPolicyRequestDto toDto(UpdateProductPolicyRequestVo updateProductPolicyRequestVo) {
		return UpdateProductPolicyRequestDto.builder()
			.productPolicyUuid(updateProductPolicyRequestVo.getProductPolicyUuid())
			.productUuid(updateProductPolicyRequestVo.getProductUuid())
			.discountRate(updateProductPolicyRequestVo.getDiscountRate())
			.enabled(updateProductPolicyRequestVo.isEnabled())
			.approved(updateProductPolicyRequestVo.isApproved())
			.seed(updateProductPolicyRequestVo.getSeed())
			.llmVersionId(updateProductPolicyRequestVo.getLlmVersionId())
			.build();
	}

	public ProductPolicy updateProductPolicy(ProductPolicy productPolicy,
		UpdateProductPolicyRequestDto updateProductPolicyRequestDto) {

		return ProductPolicy.builder()
			.productPolicyUuid(productPolicy.getProductPolicyUuid())
			.productUuid(productPolicy.getProductUuid())
			.productPolicyId(productPolicy.getProductPolicyId())
			.discountRate(updateProductPolicyRequestDto.getDiscountRate())
			.enabled(updateProductPolicyRequestDto.isEnabled())
			.approved(updateProductPolicyRequestDto.isApproved())
			.seed(updateProductPolicyRequestDto.getSeed())
			.llmVersionId(updateProductPolicyRequestDto.getLlmVersionId())
			.build();
	}
}
