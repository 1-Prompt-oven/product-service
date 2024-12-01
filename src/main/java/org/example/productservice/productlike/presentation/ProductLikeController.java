package org.example.productservice.productlike.presentation;

import org.example.productservice.common.response.BaseResponse;
import org.example.productservice.productlike.application.ProductLikeService;
import org.example.productservice.productlike.dto.in.GetProductLikeListRequestDto;
import org.example.productservice.productlike.dto.out.GetProductLikeListResponseDto;
import org.example.productservice.productlike.mapper.ProductLikeMapper;
import org.example.productservice.productlike.vo.in.UpdateProductLikeRequestVo;
import org.example.productservice.productlike.vo.out.GetLikeInfoResponseVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/member/product/like")
@Tag(name = "상품 좋아요", description = "상품 좋아요 API")
public class ProductLikeController {

	private final ProductLikeMapper productLikeMapper;
	private final ProductLikeService productLikeService;

	@Operation(summary = "상품 좋아요 토글", description = "상품 좋아요 토글")
	@PutMapping
	public BaseResponse<Void> toggleProductLike(@RequestBody UpdateProductLikeRequestVo updateProductLikeRequestVo) {

		productLikeService.toggleProductLike(productLikeMapper.toDto(updateProductLikeRequestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "상품 좋아요 정보 조회", description = "상품 좋아요 정보 조회")
	@GetMapping("/{memberUuid}/{productUuid}")
	public BaseResponse<GetLikeInfoResponseVo> getProductLikeInfo(
		@PathVariable String memberUuid,
		@PathVariable String productUuid) {

		return new BaseResponse<>(
			productLikeMapper.toVo(productLikeService.getProductLikeInfo(memberUuid, productUuid)));
	}

	@Operation(summary = "좋아요한 상품 목록 조회", description = "좋아요한 상품 목록 조회")
	@GetMapping("/list")
	public BaseResponse<GetProductLikeListResponseDto> getLikedProductList(
		@RequestParam String memberUuid,
		@RequestParam(required = false) Long cursorId,
		@RequestParam int pageSize,
		@RequestParam(required = false) String sortOption
	) {

		GetProductLikeListRequestDto getProductLikeListRequestDto =
			productLikeMapper.toDto(memberUuid, cursorId, pageSize, sortOption);

		return new BaseResponse<>(
			productLikeMapper.toVo(productLikeService.getLikedProductList(getProductLikeListRequestDto)));
	}
}
