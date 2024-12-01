package org.example.productservice.product.mapper;

import org.example.productservice.common.utils.UuidGenerator;
import org.example.productservice.product.domain.Product;
import org.example.productservice.product.dto.in.AddProductRequestDto;
import org.example.productservice.product.dto.in.GetProductListRequestDto;
import org.example.productservice.product.dto.in.UpdateProductRequestDto;
import org.example.productservice.product.dto.message.GetProductListResponseDto;
import org.example.productservice.product.dto.out.GetProductDetailResponseDto;
import org.example.productservice.product.dto.out.GetSellerUuidByProductUuidResponseDto;
import org.example.productservice.product.dto.out.ProductDto;
import org.example.productservice.product.vo.in.AddProductRequestVo;
import org.example.productservice.product.vo.in.GetProductListRequestVo;
import org.example.productservice.product.vo.in.UpdateProductRequestVo;
import org.example.productservice.product.vo.out.GetProductDetailResponseVo;
import org.example.productservice.product.vo.out.GetProductListResponseVo;
import org.example.productservice.product.vo.out.GetSellerUuidByProductUuidResponseVo;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

	public Product createProduct(AddProductRequestDto addProductRequestDto, String encryptedPrompt) {

		return Product.builder()
			.sellerUuid(addProductRequestDto.getSellerUuid())
			.productUuid(UuidGenerator.generateProductUuid())
			.productName(addProductRequestDto.getProductName())
			.price(addProductRequestDto.getPrice())
			.prompt(encryptedPrompt)
			.description(addProductRequestDto.getDescription())
			.llmId(addProductRequestDto.getLlmId())
			.topCategoryUuid(addProductRequestDto.getTopCategoryUuid())
			.subCategoryUuid(addProductRequestDto.getSubCategoryUuid())
			.contents(addProductRequestDto.getContents())
			.enabled(true)
			.temporaryEnrolled(true)
			.approved(true)
			.discountRate(addProductRequestDto.getDiscountRate())
			.seed(addProductRequestDto.getSeed())
			.llmVersionId(addProductRequestDto.getLlmVersionId())
			.sells(0L)
			.avgStar(0.0)
			.reviewCount(0L)
			.build();
	}

	public Product temporaryCreateProduct(AddProductRequestDto addProductRequestDto, String encryptedPrompt) {

		return Product.builder()
			.sellerUuid(addProductRequestDto.getSellerUuid())
			.productUuid(UuidGenerator.generateProductUuid())
			.productName(addProductRequestDto.getProductName())
			.price(addProductRequestDto.getPrice())
			.prompt(encryptedPrompt)
			.description(addProductRequestDto.getDescription())
			.llmId(addProductRequestDto.getLlmId())
			.topCategoryUuid(addProductRequestDto.getTopCategoryUuid())
			.subCategoryUuid(addProductRequestDto.getSubCategoryUuid())
			.contents(addProductRequestDto.getContents())
			.enabled(true)
			.temporaryEnrolled(true)
			.approved(true)
			.discountRate(addProductRequestDto.getDiscountRate())
			.seed(addProductRequestDto.getSeed())
			.llmVersionId(addProductRequestDto.getLlmVersionId())
			.sells(0L)
			.avgStar(0.0)
			.reviewCount(0L)
			.build();
	}

	public AddProductRequestDto toDto(AddProductRequestVo addProductRequestVo) {

		return AddProductRequestDto.builder()
			.sellerUuid(addProductRequestVo.getSellerUuid())
			.productName(addProductRequestVo.getProductName())
			.price(addProductRequestVo.getPrice())
			.prompt(addProductRequestVo.getPrompt())
			.description(addProductRequestVo.getDescription())
			.llmId(addProductRequestVo.getLlmId())
			.topCategoryUuid(addProductRequestVo.getTopCategoryUuid())
			.subCategoryUuid(addProductRequestVo.getSubCategoryUuid())
			.contents(addProductRequestVo.getContents())
			.discountRate(addProductRequestVo.getDiscountRate())
			.seed(addProductRequestVo.getSeed())
			.llmVersionId(addProductRequestVo.getLlmVersionId())
			.build();

	}

	public Product updateProduct(Product product, UpdateProductRequestDto updateProductRequestDto) {
		return Product.builder()
			.id(product.getId())
			.productUuid(product.getProductUuid())
			.sellerUuid(product.getSellerUuid())
			.productName(updateProductRequestDto.getProductName())
			.price(updateProductRequestDto.getPrice())
			.prompt(updateProductRequestDto.getPrompt())
			.description(updateProductRequestDto.getDescription())
			.llmId(updateProductRequestDto.getLlmId())
			.topCategoryUuid(updateProductRequestDto.getTopCategoryUuid())
			.subCategoryUuid(updateProductRequestDto.getSubCategoryUuid())
			.deleted(product.isDeleted())
			.temporaryEnrolled(product.isTemporaryEnrolled())
			.contents(updateProductRequestDto.getContents())
			.discountRate(updateProductRequestDto.getDiscountRate())
			.enabled(updateProductRequestDto.isEnabled())
			.approved(updateProductRequestDto.isApproved())
			.seed(updateProductRequestDto.getSeed())
			.llmVersionId(updateProductRequestDto.getLlmVersionId())
			.avgStar(product.getAvgStar())
			.sells(product.getSells())
			.createdAt(product.getCreatedAt())
			.likeCount(product.getLikeCount())
			.reviewCount(product.getReviewCount())
			.build();
	}

	public UpdateProductRequestDto toDto(UpdateProductRequestVo updateProductRequestVo) {
		return UpdateProductRequestDto.builder()
			.productUuid(updateProductRequestVo.getProductUuid())
			.productName(updateProductRequestVo.getProductName())
			.price(updateProductRequestVo.getPrice())
			.prompt(updateProductRequestVo.getPrompt())
			.description(updateProductRequestVo.getDescription())
			.llmId(updateProductRequestVo.getLlmId())
			.topCategoryUuid(updateProductRequestVo.getTopCategoryUuid())
			.subCategoryUuid(updateProductRequestVo.getSubCategoryUuid())
			.contents(updateProductRequestVo.getContents())
			.discountRate(updateProductRequestVo.getDiscountRate())
			.enabled(updateProductRequestVo.isEnabled())
			.approved(updateProductRequestVo.isApproved())
			.seed(updateProductRequestVo.getSeed())
			.llmVersionId(updateProductRequestVo.getLlmVersionId())
			.build();
	}

	public Product deleteProduct(Product product) {
		return Product.builder()
			.id(product.getId())
			.productName(product.getProductName())
			.productUuid(product.getProductUuid())
			.enabled(true)
			.deleted(true)
			.description(product.getDescription())
			.price(product.getPrice())
			.seed(product.getSeed())
			.llmId(product.getLlmId())
			.temporaryEnrolled(product.isTemporaryEnrolled())
			.topCategoryUuid(product.getTopCategoryUuid())
			.subCategoryUuid(product.getSubCategoryUuid())
			.contents(product.getContents())
			.discountRate(product.getDiscountRate())
			.llmVersionId(product.getLlmVersionId())
			.sellerUuid(product.getSellerUuid())
			.prompt(product.getPrompt())
			.approved(product.isApproved())
			.avgStar(product.getAvgStar())
			.sells(product.getSells())
			.reviewCount(product.getReviewCount())
			.build();
	}

	public GetProductDetailResponseDto toDto(Product product) {
		return GetProductDetailResponseDto.builder()
			.productUuid(product.getProductUuid())
			.sellerUuid(product.getSellerUuid())
			.productName(product.getProductName())
			.price(product.getPrice())
			.prompt(product.getPrompt())
			.description(product.getDescription())
			.llmId(product.getLlmId())
			.topCategoryUuid(product.getTopCategoryUuid())
			.subCategoryUuid(product.getSubCategoryUuid())
			.contents(product.getContents())
			.discountRate(product.getDiscountRate())
			.enabled(product.isEnabled())
			.approved(product.isApproved())
			.seed(product.getSeed())
			.llmVersionId(product.getLlmVersionId())
			.avgStar(product.getAvgStar())
			.sells(product.getSells())
			.reviewCount(product.getReviewCount())
			.createdAt(product.getCreatedAt())
			.updatedAt(product.getUpdatedAt())
			.build();
	}

	public GetProductDetailResponseVo toVo(GetProductDetailResponseDto getProductDetailResponseDto) {
		return GetProductDetailResponseVo.builder()
			.productUuid(getProductDetailResponseDto.getProductUuid())
			.sellerUuid(getProductDetailResponseDto.getSellerUuid())
			.productName(getProductDetailResponseDto.getProductName())
			.price(getProductDetailResponseDto.getPrice())
			.prompt(getProductDetailResponseDto.getPrompt())
			.description(getProductDetailResponseDto.getDescription())
			.llmId(getProductDetailResponseDto.getLlmId())
			.topCategoryUuid(getProductDetailResponseDto.getTopCategoryUuid())
			.subCategoryUuid(getProductDetailResponseDto.getSubCategoryUuid())
			.contents(getProductDetailResponseDto.getContents())
			.discountRate(getProductDetailResponseDto.getDiscountRate())
			.enabled(getProductDetailResponseDto.isEnabled())
			.approved(getProductDetailResponseDto.isApproved())
			.seed(getProductDetailResponseDto.getSeed())
			.llmVersionId(getProductDetailResponseDto.getLlmVersionId())
			.avgStar(getProductDetailResponseDto.getAvgStar())
			.sells(getProductDetailResponseDto.getSells())
			.reviewCount(getProductDetailResponseDto.getReviewCount())
			.createdAt(getProductDetailResponseDto.getCreatedAt())
			.updatedAt(getProductDetailResponseDto.getUpdatedAt())
			.build();
	}

	public GetSellerUuidByProductUuidResponseDto toSellerUuidDto(Product product) {

		return GetSellerUuidByProductUuidResponseDto.builder()
			.sellerUuid(product.getSellerUuid())
			.build();
	}

	public GetSellerUuidByProductUuidResponseVo toVo(GetSellerUuidByProductUuidResponseDto getSellerUuidByProductUuidResponseDto) {

		return GetSellerUuidByProductUuidResponseVo.builder()
			.sellerUuid(getSellerUuidByProductUuidResponseDto.getSellerUuid())
			.build();
	}

	public ProductDto productToDto(Product product) {
		return ProductDto.builder()
			.productUuid(product.getProductUuid())
			.productName(product.getProductName())
			.price(product.getPrice())
			.topCategoryUuid(product.getTopCategoryUuid())
			.subCategoryUuid(product.getSubCategoryUuid())
			.discountRate(product.getDiscountRate())
			.description(product.getDescription())
			.enabled(product.isEnabled())
			.avgStar(product.getAvgStar())
			.sells(product.getSells())
			.likeCount(product.getLikeCount())
			.description(product.getDescription())
			.llmId(product.getLlmId())
			.createdAt(product.getCreatedAt())
			.reviewCount(product.getReviewCount())
			.thumbnailUrl(product.getContents().getFirst().getContentUrl())
			.build();
	}

	public GetProductListRequestDto toDto(GetProductListRequestVo getProductListRequestVo) {
		return GetProductListRequestDto.builder()
			.pageSize(getProductListRequestVo.getPageSize())
			.cursorId(getProductListRequestVo.getCursorId())
			.searchBar(getProductListRequestVo.getSearchBar())
			.topCategoryUuid(getProductListRequestVo.getTopCategoryUuid())
			.subCategoryUuid(getProductListRequestVo.getSubCategoryUuid())
			.minPrice(getProductListRequestVo.getMinPrice())
			.maxPrice(getProductListRequestVo.getMaxPrice())
			.llmIdList(getProductListRequestVo.getLlmList())
			.enable(getProductListRequestVo.isEnable())
			.sortOption(getProductListRequestVo.getSortOption())
			.sortBy(getProductListRequestVo.getSortDate())
			.build();

	}

	public GetProductListResponseVo toVo(GetProductListResponseDto getProductListResponseDto) {
		return GetProductListResponseVo.builder()
			.productList(getProductListResponseDto.getProductList())
			.nextCursorId(getProductListResponseDto.getNextCursorId())
			.hasNext(getProductListResponseDto.isHasNext())
			.build();
	}
}
