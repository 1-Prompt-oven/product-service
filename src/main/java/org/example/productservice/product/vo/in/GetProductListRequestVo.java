package org.example.productservice.product.vo.in;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetProductListRequestVo {

	private String searchBar;
	private String topCategoryUuid;
	private String subCategoryUuid;
	private boolean enable;
	private String minPrice;
	private String maxPrice;
	private String sortOption;
	private String sortDate;
	private int pageSize;
	private String cursorId;
	private List<Long> llmList;
}
