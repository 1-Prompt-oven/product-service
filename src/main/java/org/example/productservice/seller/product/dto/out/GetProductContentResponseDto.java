package org.example.productservice.seller.product.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class GetProductContentResponseDto {

	private String productContentUuid;
	private String productUuid;
	private String contentUrl;
	private int order;
	private String sampleValue;
}
