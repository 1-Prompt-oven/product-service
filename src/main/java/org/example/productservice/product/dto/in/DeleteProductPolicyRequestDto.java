package org.example.productservice.product.dto.in;

import org.example.productservice.product.domain.ProductPolicy;
import org.example.productservice.product.vo.in.DeleteProductContentRequestVo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class DeleteProductPolicyRequestDto {

	private String productPolicyUuid;

	public static DeleteProductPolicyRequestDto toDto(DeleteProductContentRequestVo deleteProductContentRequestVo) {

		return DeleteProductPolicyRequestDto.builder()
			.productPolicyUuid(deleteProductContentRequestVo.getProductContentUuid())
			.build();
	}

	public ProductPolicy deleteEntity(ProductPolicy productPolicy) {

		return ProductPolicy.builder()
			.productPolicyUuid(productPolicy.getProductPolicyUuid())
			.productUuid(productPolicy.getProductUuid())
			.productPolicyId(productPolicy.getProductPolicyId())
			.seed(productPolicy.getSeed())
			.enabled(productPolicy.isEnabled())
			.deleted(true)
			.approved(productPolicy.isApproved())
			.discountRate(productPolicy.getDiscountRate())
			.llmVersionId(productPolicy.getLlmVersionId())
			.build();
	}
}
