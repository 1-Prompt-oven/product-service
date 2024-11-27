package org.example.productservice.seller.product.dto.out;

import org.example.productservice.common.domain.Product;
import org.example.productservice.common.domain.ProductPolicy;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class GetProductDetailResponseDto {

	private String productUuid;

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

	@Builder
	public GetProductDetailResponseDto(String productUuid, String sellerUuid, String sellerName, int price, String prompt,
		String description, float discountRate, boolean enabled, boolean premium, String thumbnailSrc, boolean approved,
		Long llmId) {
		this.productUuid = productUuid;
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

	public static GetProductDetailResponseDto toDto(Product product, ProductPolicy productPolicy) {
		return GetProductDetailResponseDto.builder()
			.productUuid(product.getProductUuid())
			.sellerUuid(product.getSellerUuid())
			.sellerName(product.getSellerName())
			.price(product.getPrice())
			.prompt(product.getPrompt())
			.description(product.getDescription())
			.discountRate(productPolicy.getDiscountRate())
			.enabled(productPolicy.isEnabled())
			.premium(productPolicy.isPremium())
			.thumbnailSrc(productPolicy.getThumbnailSrc())
			.approved(productPolicy.isApproved())
			.llmId(productPolicy.getLlmId())
			.build();
	}
}
