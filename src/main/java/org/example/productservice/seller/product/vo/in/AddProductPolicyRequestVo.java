package org.example.productservice.seller.product.vo.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class AddProductPolicyRequestVo {

	private int price;
	private String productUuid;
	private float discountRate;
	private boolean enabled;
	private boolean deleted;
	private boolean approved;
	private String seed;
	private Long llmVersion;
	private String llmVersionName;
}
