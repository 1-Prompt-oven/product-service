package org.example.productservice.seller.product.dto.in;

import org.example.productservice.common.product.domain.ProductContent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class UpdateProductContentRequestDto {

	private String productContentUuid;
	private String productUuid;
	private String contentUrl;
	private int order;
	private String sampleValue;

	public ProductContent updateProductContent(Long productContentId) {
		return ProductContent.builder()
			.productContentId(productContentId)
			.productContentUuid(productContentUuid)
			.productUuid(productUuid)
			.contentUrl(contentUrl)
			.order(order)
			.sampleValue(sampleValue)
			.deleted(false)
			.build();
	}
}
