package org.example.productservice.product.dto.in;

import org.example.productservice.product.domain.ProductContent;
import org.example.productservice.product.vo.in.DeleteProductContentRequestVo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteProductContentRequestDto {

	private String productContentUuid;

	public static DeleteProductContentRequestDto toDto(DeleteProductContentRequestVo deleteProductContentRequestVo) {

		return DeleteProductContentRequestDto.builder()
			.productContentUuid(deleteProductContentRequestVo.getProductContentUuid())
			.build();
	}

	public ProductContent deleteEntity(ProductContent productContent) {
		return ProductContent.builder()
			.productContentId(productContent.getProductContentId())
			.productContentUuid(productContent.getProductContentUuid())
			.productUuid(productContent.getProductUuid())
			.contentUrl(productContent.getContentUrl())
			.contentOrder(productContent.getContentOrder())
			.sampleValue(productContent.getSampleValue())
			.deleted(true)
			.build();
	}
}
