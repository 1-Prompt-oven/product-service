package org.example.productservice.productlike.application;

import org.example.productservice.productlike.dto.in.GetProductLikeListRequestDto;
import org.example.productservice.productlike.dto.in.UpdateProductLikeRequestDto;
import org.example.productservice.productlike.dto.out.GetLikeInfoResponseDto;
import org.example.productservice.productlike.dto.out.GetProductLikeListResponseDto;

public interface ProductLikeService {

	void toggleProductLike(UpdateProductLikeRequestDto updateProductLikeRequestDto);

	GetLikeInfoResponseDto getProductLikeInfo(String memberUuid, String productUuid);

	GetProductLikeListResponseDto getLikedProductList(GetProductLikeListRequestDto requestDto);
}
