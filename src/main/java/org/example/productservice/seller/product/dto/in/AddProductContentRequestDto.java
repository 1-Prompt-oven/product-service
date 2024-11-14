package org.example.productservice.seller.product.dto.in;

import org.example.productservice.common.product.domain.ProductContent;
import org.example.productservice.global.common.UuidGenerator;
import org.example.productservice.seller.product.vo.in.AddProductContentRequestVo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class AddProductContentRequestDto {

	private String productUuid;
	private String contentUrl;
	private int order;
	private String sampleValue;

	public static AddProductContentRequestDto toDto(AddProductContentRequestVo addProductContentRequestVo) {
		return AddProductContentRequestDto.builder()
			.productUuid(addProductContentRequestVo.getProductUuid())
			.contentUrl(addProductContentRequestVo.getContentUrl())
			.order(addProductContentRequestVo.getOrder())
			.sampleValue(addProductContentRequestVo.getSampleValue())
			.build();
	}

	public ProductContent createProductContent() {
		return ProductContent.builder()
			.productContentUuid(UuidGenerator.generateProductContentUuid())
			.productUuid(productUuid)
			.contentUrl(contentUrl)
			.order(order)
			.sampleValue(sampleValue)
			.deleted(false)
			.build();
	}
}
