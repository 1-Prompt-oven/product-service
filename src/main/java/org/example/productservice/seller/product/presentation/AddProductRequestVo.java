package org.example.productservice.seller.product.presentation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class AddProductRequestVo {

	private String sellerUuid;

	private String sellerName;

	private String productName;

	private int price;

	private String prompt;

	private String description;

	private float discountRate;

	private boolean enabled;

	private String thumbnailSrc;

	private boolean approved;

	private Long llmId;

	@Schema(description = "모델 이름", example = "Midjourney")
	private String llmName;
}
