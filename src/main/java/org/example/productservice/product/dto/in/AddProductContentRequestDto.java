package org.example.productservice.product.dto.in;

import org.example.productservice.product.domain.ProductContent;
import org.example.productservice.common.utils.UuidGenerator;
import org.example.productservice.product.vo.in.AddProductContentRequestVo;

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
	private int contentOrder;
	private String sampleValue;

	public static AddProductContentRequestDto toDto(AddProductContentRequestVo addProductContentRequestVo) {
		return AddProductContentRequestDto.builder()
			.productUuid(addProductContentRequestVo.getProductUuid())
			.contentUrl(addProductContentRequestVo.getContentUrl())
			.contentOrder(addProductContentRequestVo.getOrder())
			.sampleValue(addProductContentRequestVo.getSampleValue())
			.build();
	}

	public ProductContent createEntity() {
		return ProductContent.builder()
			.productContentUuid(UuidGenerator.generateProductContentUuid())
			.productUuid(productUuid)
			.contentUrl(contentUrl)
			.contentOrder(contentOrder)
			.sampleValue(sampleValue)
			.deleted(false)
			.build();
	}
}
