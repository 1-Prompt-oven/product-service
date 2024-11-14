package org.example.productservice.seller.product.dto.in;

import org.example.productservice.common.product.domain.ProductContent;
import org.example.productservice.seller.product.vo.in.UpdateProductContentRequestVo;

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
	private int contentOrder;
	private String sampleValue;

	public static UpdateProductContentRequestDto toDto(UpdateProductContentRequestVo updateProductContentRequestVo) {
		return UpdateProductContentRequestDto.builder()
			.productContentUuid(updateProductContentRequestVo.getProductContentUuid())
			.productUuid(updateProductContentRequestVo.getProductUuid())
			.contentUrl(updateProductContentRequestVo.getContentUrl())
			.contentOrder(updateProductContentRequestVo.getOrder())
			.sampleValue(updateProductContentRequestVo.getSampleValue())
			.build();
	}

	public ProductContent updateProductContent(Long productContentId) {
		return ProductContent.builder()
			.productContentId(productContentId)
			.productContentUuid(productContentUuid)
			.productUuid(productUuid)
			.contentUrl(contentUrl)
			.contentOrder(contentOrder)
			.sampleValue(sampleValue)
			.deleted(false)
			.build();
	}
}
