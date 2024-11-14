package org.example.productservice.seller.product.dto.in;

import org.example.productservice.seller.product.vo.in.GetProductDetailRequestVo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetProductDetailRequestDto {

	private String productUuid;

	public static GetProductDetailRequestDto toDto(GetProductDetailRequestVo getProductDetailRequestVo) {
		return GetProductDetailRequestDto.builder()
			.productUuid(getProductDetailRequestVo.getProductUuid())
			.build();
	}
}
