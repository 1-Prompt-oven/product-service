package org.example.productservice.seller.product.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class UpdateProductPolicyRequestVo {

	private String productPolicyUuid;
	private String productUuid;
	private float discountRate;
	private boolean enabled;
	private boolean approved;
	private Long llmId;
	private String llmName;

}
