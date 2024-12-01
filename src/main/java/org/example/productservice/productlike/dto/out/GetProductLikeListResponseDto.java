package org.example.productservice.productlike.dto.out;

import java.util.List;

import org.example.productservice.product.dto.out.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetProductLikeListResponseDto {

	private List<ProductDto> productList;
	private String nextCursorId;
	private boolean hasNext;
}
