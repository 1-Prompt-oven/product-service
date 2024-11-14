package org.example.productservice.seller.product.vo.in;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
public class UpdateProductRequestVo {

	private String productPolicyUuid;

	private String productUuid;

	private String sellerUuid;

	private String sellerName;

	private int price;

	private String productName;

	private String prompt;

	private String description;

	private float discountRate;

	private boolean enabled;

	private boolean premium;

	private String thumbnailSrc;

	private boolean approved;

	private Long llmId;

	private List<ProductContentRequestVo> productContentRequestVo;
}
