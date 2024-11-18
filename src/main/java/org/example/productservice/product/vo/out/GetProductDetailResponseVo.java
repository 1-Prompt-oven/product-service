package org.example.productservice.product.vo.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetProductDetailResponseVo {

	private String productUuid;

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
