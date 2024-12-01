package org.example.productservice.productlike.mapper;

import org.example.productservice.product.domain.Product;
import org.example.productservice.product.dto.out.ProductDto;
import org.example.productservice.productlike.domain.ProductLike;
import org.example.productservice.productlike.dto.in.GetProductLikeListRequestDto;
import org.example.productservice.productlike.dto.in.UpdateProductLikeRequestDto;
import org.example.productservice.productlike.dto.out.GetLikeInfoResponseDto;
import org.example.productservice.productlike.dto.out.GetProductLikeListResponseDto;
import org.example.productservice.productlike.vo.in.UpdateProductLikeRequestVo;
import org.example.productservice.productlike.vo.out.GetLikeInfoResponseVo;
import org.springframework.stereotype.Component;

@Component
public class ProductLikeMapper {

	public ProductLike createEntity(UpdateProductLikeRequestDto updateProductLikeRequestDto) {
		return ProductLike.builder()
			.productUuid(updateProductLikeRequestDto.getProductUuid())
			.memberUuid(updateProductLikeRequestDto.getMemberUuid())
			.liked(true)
			.build();
	}

	public ProductLike updateEntity(ProductLike productLike) {
		return ProductLike.builder()
			.productLikeId(productLike.getProductLikeId())
			.productUuid(productLike.getProductUuid())
			.memberUuid(productLike.getMemberUuid())
			.liked(!productLike.isLiked())
			.build();
	}

	public UpdateProductLikeRequestDto toDto(UpdateProductLikeRequestVo updateProductLikeRequestVo) {

		return UpdateProductLikeRequestDto.builder()
			.memberUuid(updateProductLikeRequestVo.getMemberUuid())
			.productUuid(updateProductLikeRequestVo.getProductUuid())
			.build();
	}

	public GetLikeInfoResponseDto toDto(ProductLike productLike) {

		return GetLikeInfoResponseDto.builder()
			.liked(productLike.isLiked())
			.build();
	}

	public GetLikeInfoResponseVo toVo(GetLikeInfoResponseDto likeInfo) {

		return GetLikeInfoResponseVo.builder()
			.liked(likeInfo.isLiked())
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

	public GetProductLikeListRequestDto toDto(String memberUuid, Long cursorId, int pageSize, String sortOption) {

		return GetProductLikeListRequestDto.builder()
			.memberUuid(memberUuid)
			.cursorId(cursorId)
			.pageSize(pageSize)
			.sortOption(sortOption)
			.build();
	}

	public GetProductLikeListResponseDto toVo(GetProductLikeListResponseDto responseDto) {

		return GetProductLikeListResponseDto.builder()
			.productList(responseDto.getProductList())
			.nextCursorId(responseDto.getNextCursorId())
			.hasNext(responseDto.isHasNext())
			.build();
	}

}
