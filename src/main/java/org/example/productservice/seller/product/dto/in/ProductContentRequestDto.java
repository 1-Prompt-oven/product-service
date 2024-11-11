package org.example.productservice.seller.product.dto.in;

import org.example.productservice.seller.product.vo.in.ProductContentRequestVo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ProductContentRequestDto {

	private String contentUrl;
	private int order;
	private String sampleValue;

	public static ProductContentRequestDto toDto(ProductContentRequestVo productContentRequestVo) {
		return ProductContentRequestDto.builder()
				.contentUrl(productContentRequestVo.getContentUrl())
				.order(productContentRequestVo.getOrder())
				.sampleValue(productContentRequestVo.getSampleValue())
				.build();
	}
}
