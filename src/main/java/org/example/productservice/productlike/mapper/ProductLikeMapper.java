package org.example.productservice.productlike.mapper;

import org.example.productservice.productlike.domain.ProductLike;
import org.example.productservice.productlike.dto.in.UpdateProductLikeRequestDto;
import org.example.productservice.productlike.dto.out.GetLikeInfoResponseDto;
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
}
