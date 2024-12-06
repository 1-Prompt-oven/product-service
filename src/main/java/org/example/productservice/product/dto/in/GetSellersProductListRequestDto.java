package org.example.productservice.product.dto.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class GetSellersProductListRequestDto {

	private String sellerUuid;
	private String searchBar;
	private String sortBy;
	private String sortOption;
	private boolean enable;
	private boolean temporary;
	private String cursorId;
	private int pageSize;
}
