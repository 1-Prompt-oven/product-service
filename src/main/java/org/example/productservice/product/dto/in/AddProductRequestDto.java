package org.example.productservice.product.dto.in;

import java.util.List;

import org.example.productservice.product.domain.Product;
import org.example.productservice.product.domain.ProductContent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class AddProductRequestDto {

	private String sellerUuid;
	private String productName;
	private double price;
	private String prompt;
	private String description;
	private Long llmId;
	private String topCategoryUuid;
	private String subCategoryUuid;
	private boolean deleted;
	private List<ProductContent> contents;
	private float discountRate;
	private String seed;
	private Long llmVersionId;




}
