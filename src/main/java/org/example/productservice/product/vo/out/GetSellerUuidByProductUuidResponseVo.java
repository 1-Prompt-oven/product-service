package org.example.productservice.product.vo.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetSellerUuidByProductUuidResponseVo {

	private String sellerUuid;
}
