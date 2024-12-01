package org.example.productservice.product.dto.out;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ProductDto {

	private String productUuid;
	private String productName;
	private double price;
	private String topCategoryUuid;
	private String subCategoryUuid;
	private boolean enabled;
	private double avgStar;
	private Long sells;
	private Long likeCount;
	private Long llmId;
	private String description;
	private double discountRate;
	private Long reviewCount;
	private LocalDateTime createdAt;
	private String thumbnailUrl;
}
