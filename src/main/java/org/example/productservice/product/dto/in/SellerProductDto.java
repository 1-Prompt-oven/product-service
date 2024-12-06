package org.example.productservice.product.dto.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerProductDto {

	private String productName;
	private String productUuid;
	private double price;
	private Long sells;
	private boolean enable;
	private boolean temporary;
}
