package org.example.productservice.seller.product.dto.in;

import org.example.productservice.common.domain.Product;
import org.example.productservice.common.domain.ProductPolicy;
import org.example.productservice.global.common.UuidGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AddProductRequestDto {

	private String sellerUuid;

	private String sellerName;

	private int price;

	private String prompt;

	private String description;

	private float discountRate;

	private boolean enabled;

	private boolean premium;

	private String thumbnailSrc;

	private boolean approved;

	private Long llmId;

	public AddProductRequestDto(String sellerUuid, String sellerName, int price, String prompt, String description,
		float discountRate, boolean enabled, boolean premium, String thumbnailSrc, boolean approved, Long llmId) {
		this.sellerUuid = sellerUuid;
		this.sellerName = sellerName;
		this.price = price;
		this.prompt = prompt;
		this.description = description;
		this.discountRate = discountRate;
		this.enabled = enabled;
		this.premium = premium;
		this.thumbnailSrc = thumbnailSrc;
		this.approved = approved;
		this.llmId = llmId;
	}

	public Product createProduct() {
		return Product.builder()
			.productUuid(UuidGenerator.generateProductUuid())
				.sellerUuid(sellerUuid)
				.sellerName(sellerName)
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
