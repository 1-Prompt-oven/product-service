package org.example.productservice.seller.product.dto.in;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetProductDetailRequestDto {

	private String productUuid;

	public GetProductDetailRequestDto(String productUuid) {
		this.productUuid = productUuid;
	}
}
