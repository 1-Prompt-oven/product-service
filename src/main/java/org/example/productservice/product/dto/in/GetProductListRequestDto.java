package org.example.productservice.product.dto.in;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetProductListRequestDto {

	private String searchBar;
	private String topCategoryUuid;
	private String subCategoryUuid;
	private Boolean enable;
	private String minPrice;
	private String maxPrice;
	private String sortOption;
	private String sortBy;
	private int pageSize;
	private String cursorId;
	private List<Long> llmIdList;
}
