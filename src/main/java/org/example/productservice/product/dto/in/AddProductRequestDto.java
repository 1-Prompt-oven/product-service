package org.example.productservice.product.dto.in;

import org.example.productservice.product.domain.Product;
import org.example.productservice.common.utils.UuidGenerator;
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
	private int price;
	private String productName;
	private String prompt;
	private String description;
	private Long llmId;
	private String topCategoryUuid;
	private String subCategoryUuid;

	public static AddProductRequestDto toDto(AddProductRequestVo addProductRequestVo) {
		return AddProductRequestDto.builder()
			.sellerUuid(addProductRequestVo.getSellerUuid())
			.price(addProductRequestVo.getPrice())
			.productName(addProductRequestVo.getProductName())
			.prompt(addProductRequestVo.getPrompt())
			.description(addProductRequestVo.getDescription())
			.llmId(addProductRequestVo.getLlmId())
			.topCategoryUuid(addProductRequestVo.getTopCategoryUuid())
			.subCategoryUuid(addProductRequestVo.getSubCategoryUuid())
			.build();
	}

	public Product createProduct(String encryptedPrompt) {

		return Product.builder()
			.productUuid(UuidGenerator.generateProductUuid())
				.sellerUuid(sellerUuid)
				.productName(productName)
				.price(price)
				.prompt(encryptedPrompt)
				.description(description)
				.llmId(llmId)
				.topCategoryUuid(topCategoryUuid)
				.subCategoryUuid(subCategoryUuid)
				.deleted(false)
				.build();
	}


}
