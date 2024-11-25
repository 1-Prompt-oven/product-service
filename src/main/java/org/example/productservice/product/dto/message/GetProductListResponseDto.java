package org.example.productservice.product.dto.message;

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
public class GetProductListResponseDto {

	private List<ProductDto> productList;
	private String nextCursorId;
	private boolean hasNext;
}
