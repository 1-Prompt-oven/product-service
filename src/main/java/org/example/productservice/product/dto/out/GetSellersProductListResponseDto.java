package org.example.productservice.product.dto.out;

import java.util.List;

import org.example.productservice.product.dto.in.SellerProductDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class GetSellersProductListResponseDto {

	private List<SellerProductDto> productList;
	private String nextCursorId;
	private boolean hasNext;
}
