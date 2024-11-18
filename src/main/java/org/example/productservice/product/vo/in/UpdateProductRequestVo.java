package org.example.productservice.product.vo.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
public class UpdateProductRequestVo {

	private String productUuid;

	private String sellerUuid;

	private String sellerName;

	private int price;

	private String productName;

	private String prompt;

	private String description;

	private Long llmId;

	private String llmName;

	private String topCategoryUuid;

	private String topCategoryName;

	private String subCategoryUuid;

	private String subCategoryName;
}
