package org.example.productservice.productlike.application;

import org.example.productservice.productlike.dto.in.UpdateProductLikeRequestDto;
import org.example.productservice.productlike.dto.out.GetLikeInfoResponseDto;

public interface ProductLikeService {

	void toggleProductLike(UpdateProductLikeRequestDto updateProductLikeRequestDto);

	GetLikeInfoResponseDto getProductLikeInfo(String memberUuid, String productUuid);
}
