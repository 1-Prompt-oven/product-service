package org.example.productservice.product.dto.in;

import org.example.productservice.product.domain.ProductContent;
import org.example.productservice.product.vo.in.UpdateProductContentRequestVo;

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

	public ProductContent updateEntity(ProductContent productContent,
		UpdateProductContentRequestDto updateProductContentRequestDto) {

		return ProductContent.builder()
			.productContentId(productContent.getProductContentId())
			.productContentUuid(updateProductContentRequestDto.getProductContentUuid())
			.productUuid(productContent.getProductUuid())
			.contentUrl(updateProductContentRequestDto.getContentUrl())
			.contentOrder(updateProductContentRequestDto.getContentOrder())
			.sampleValue(updateProductContentRequestDto.getSampleValue())
			.deleted(productContent.isDeleted())
			.build();
	}
}
