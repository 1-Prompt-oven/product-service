package org.example.productservice.product.vo.out;

import java.util.List;

import org.example.productservice.product.dto.in.SellerProductDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetSellersProductListResponseVo {

	private List<SellerProductDto> productList;
	private String nextCursorId;
	private boolean hasNext;
}
