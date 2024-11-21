package org.example.productservice.product.dto.in;

import java.util.List;

import org.example.productservice.product.domain.Product;
import org.example.productservice.product.domain.ProductContent;
import org.example.productservice.product.vo.in.UpdateProductRequestVo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class UpdateProductRequestDto {

	private String productUuid;
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
	private boolean enabled;
	private boolean approved;
	private String seed;
	private Long llmVersionId;


	public static UpdateProductRequestDto toDto(UpdateProductRequestVo updateProductRequestVo) {
		return UpdateProductRequestDto.builder()
			.productUuid(updateProductRequestVo.getProductUuid())
			.productName(updateProductRequestVo.getProductName())
			.price(updateProductRequestVo.getPrice())
			.prompt(updateProductRequestVo.getPrompt())
			.description(updateProductRequestVo.getDescription())
			.llmId(updateProductRequestVo.getLlmId())
			.topCategoryUuid(updateProductRequestVo.getTopCategoryUuid())
			.subCategoryUuid(updateProductRequestVo.getSubCategoryUuid())
			.deleted(updateProductRequestVo.isDeleted())
			.contents(updateProductRequestVo.getContents())
			.discountRate(updateProductRequestVo.getDiscountRate())
			.enabled(updateProductRequestVo.isEnabled())
			.approved(updateProductRequestVo.isApproved())
			.seed(updateProductRequestVo.getSeed())
			.llmVersionId(updateProductRequestVo.getLlmVersionId())
			.build();
	}

	public Product updateProduct(Product product, UpdateProductRequestDto updateProductRequestDto) {
		return Product.builder()
			.productUuid(product.getProductUuid())
			.sellerUuid(product.getSellerUuid())
			.productName(updateProductRequestDto.getProductName())
			.price(updateProductRequestDto.getPrice())
			.prompt(updateProductRequestDto.getPrompt())
			.description(updateProductRequestDto.getDescription())
			.llmId(updateProductRequestDto.getLlmId())
			.topCategoryUuid(updateProductRequestDto.getTopCategoryUuid())
			.subCategoryUuid(updateProductRequestDto.getSubCategoryUuid())
			.deleted(updateProductRequestDto.isDeleted())
			.contents(updateProductRequestDto.getContents())
			.discountRate(updateProductRequestDto.getDiscountRate())
			.enabled(updateProductRequestDto.isEnabled())
			.approved(updateProductRequestDto.isApproved())
			.seed(updateProductRequestDto.getSeed())
			.llmVersionId(updateProductRequestDto.getLlmVersionId())
			.build();
	}

}
