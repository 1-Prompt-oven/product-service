package org.example.productservice.seller.product.vo.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class AddProductRequestVo {

	private String sellerUuid;

	private String sellerName;

	private String productName;

	private int price;

	private String prompt;

	private String description;

	private Long llmId;

	private String llmName;

	private String topCategoryUuid;

	private String topCategoryName;

	private String subCategoryUuid;

	private String subCategoryName;
}
