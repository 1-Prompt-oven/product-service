package org.example.productservice.product.dto.in;

import java.util.List;

import org.example.productservice.product.domain.Product;
import org.example.productservice.product.domain.ProductContent;
import org.example.productservice.product.vo.in.AddProductRequestVo;

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

	public static AddProductRequestDto toDto(AddProductRequestVo addProductRequestVo) {

		return AddProductRequestDto.builder()
			.sellerUuid(addProductRequestVo.getSellerUuid())
			.productName(addProductRequestVo.getProductName())
			.price(addProductRequestVo.getPrice())
			.prompt(addProductRequestVo.getPrompt())
			.description(addProductRequestVo.getDescription())
			.llmId(addProductRequestVo.getLlmId())
			.topCategoryUuid(addProductRequestVo.getTopCategoryUuid())
			.subCategoryUuid(addProductRequestVo.getSubCategoryUuid())
			.deleted(addProductRequestVo.isDeleted())
			.contents(addProductRequestVo.getContents())
			.discountRate(addProductRequestVo.getDiscountRate())
			.seed(addProductRequestVo.getSeed())
			.llmVersionId(addProductRequestVo.getLlmVersionId())
			.build();

	}

	public Product createProduct(String encryptedPrompt) {

		return Product.builder()
			.sellerUuid(sellerUuid)
			.productName(productName)
			.price(price)
			.prompt(encryptedPrompt)
			.description(description)
			.llmId(llmId)
			.topCategoryUuid(topCategoryUuid)
			.subCategoryUuid(subCategoryUuid)
			.deleted(deleted)
			.contents(contents)
			.enabled(true)
			.approved(true)
			.discountRate(discountRate)
			.seed(seed)
			.llmVersionId(llmVersionId)
			.build();
	}


}
