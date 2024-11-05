package org.example.productservice.seller.product.dto.in;

import org.example.productservice.common.domain.Product;
import org.example.productservice.common.domain.ProductPolicy;
import org.example.productservice.global.common.UuidGenerator;
import org.example.productservice.seller.product.presentation.AddProductRequestVo;

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

	private float discountRate;

	private boolean enabled;

	private boolean premium;

	private String thumbnailSrc;

	private boolean approved;

	private Long llmId;

	public static AddProductRequestDto toDto(AddProductRequestVo addProductRequestVo) {
		return AddProductRequestDto.builder()
			.sellerUuid(addProductRequestVo.getSellerUuid())
			.sellerName(addProductRequestVo.getSellerName())
			.price(addProductRequestVo.getPrice())
			.productName(addProductRequestVo.getProductName())
			.prompt(addProductRequestVo.getPrompt())
			.description(addProductRequestVo.getDescription())
			.discountRate(addProductRequestVo.getDiscountRate())
			.enabled(addProductRequestVo.isEnabled())
			.premium(addProductRequestVo.isPremium())
			.thumbnailSrc(addProductRequestVo.getThumbnailSrc())
			.approved(addProductRequestVo.isApproved())
			.llmId(addProductRequestVo.getLlmId())
			.build();
	}

	public Product createProduct() {
		return Product.builder()
			.productUuid(UuidGenerator.generateProductUuid())
				.sellerUuid(sellerUuid)
				.sellerName(sellerName)
				.name(productName)
				.price(price)
				.prompt(prompt)
				.description(description)
				.build();
	}

	public ProductPolicy createProductPolicy(Product product) {
		return ProductPolicy.builder()
				.product(product)
				.discountRate(discountRate)
				.enabled(enabled)
				.premium(premium)
				.thumbnailSrc(thumbnailSrc)
				.approved(approved)
				.llmId(llmId)
				.build();
	}

	public Product updateProduct(Long productId) {
		return Product.builder()
			.productId(productId)
			.sellerUuid(sellerUuid)
			.name(productName)
			.price(price)
			.prompt(prompt)
			.description(description)
			.build();
	}

	public ProductPolicy updateProductPolicy(Product product) {
		return ProductPolicy.builder()
			.product(product)
			.discountRate(discountRate)
			.enabled(enabled)
			.premium(premium)
			.thumbnailSrc(thumbnailSrc)
			.approved(approved)
			.llmId(llmId)
			.build();
	}
}
