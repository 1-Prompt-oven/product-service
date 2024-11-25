package org.example.productservice.product.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class GetSellerUuidByProductUuidResponseDto {

	private String sellerUuid;
}
