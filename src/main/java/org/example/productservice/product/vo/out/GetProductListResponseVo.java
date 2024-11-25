package org.example.productservice.product.vo.out;

import java.util.List;

import org.example.productservice.product.dto.out.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class GetProductListResponseVo {

	private List<ProductDto> productList;
	private String nextCursorId;
	private boolean hasNext;
}
