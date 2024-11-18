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

	private String sellerName;

	private int price;

	private String productName;

	private String prompt;

	private String description;

	private Long llmId;

	private String llmName;

	public static AddProductRequestDto toDto(AddProductRequestVo addProductRequestVo) {
		return AddProductRequestDto.builder()
			.sellerUuid(addProductRequestVo.getSellerUuid())
			.sellerName(addProductRequestVo.getSellerName())
			.price(addProductRequestVo.getPrice())
			.productName(addProductRequestVo.getProductName())
			.prompt(addProductRequestVo.getPrompt())
			.description(addProductRequestVo.getDescription())
			.llmId(addProductRequestVo.getLlmId())
			.llmName(addProductRequestVo.getLlmName())
			.build();
	}

	public Product createProduct() {
		return Product.builder()
			.productUuid(UuidGenerator.generateProductUuid())
				.sellerUuid(sellerUuid)
				.sellerName(sellerName)
				.productName(productName)
				.price(price)
				.prompt(prompt)
				.description(description)
				.llmId(llmId)
				.llmName(llmName)
				.deleted(false)
				.build();
	}


}
