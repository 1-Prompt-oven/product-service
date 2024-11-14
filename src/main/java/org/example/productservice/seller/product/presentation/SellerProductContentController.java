package org.example.productservice.seller.product.presentation;

import org.example.productservice.global.common.response.BaseResponse;
import org.example.productservice.seller.product.application.SellerProductContentService;
import org.example.productservice.seller.product.dto.in.AddProductContentRequestDto;
import org.example.productservice.seller.product.dto.in.UpdateProductContentRequestDto;
import org.example.productservice.seller.product.vo.in.AddProductContentRequestVo;
import org.example.productservice.seller.product.vo.in.UpdateProductContentRequestVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "판매자 상품 이미지 API", description = "판매자 상품 이미지 관련 API endpoints")
@RequestMapping("/v1r/seller/product/content")
public class SellerProductContentController {

	private final SellerProductContentService sellerProductContentService;

	@Operation(summary = "상품 콘텐츠 등록", description = """
		contentUrl = 콘텐츠 URL(이미지 URL)
		order = 콘텐츠 순서
		sampleValue = 해당 샘플의 {} 내부 값
		""")
	public BaseResponse<Void> addProductContent(AddProductContentRequestVo addProductContentRequestVo) {

		sellerProductContentService.addProductContent(AddProductContentRequestDto.toDto(addProductContentRequestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "상품 콘텐츠 수정", description = """
		contentUrl = 콘텐츠 URL(이미지 URL)
		order = 콘텐츠 순서
		sampleValue = 해당 샘플의 {} 내부 값
		""")
	public BaseResponse<Void> updateProductContent(UpdateProductContentRequestVo updateProductContentRequestVo) {

		sellerProductContentService.updateProductContent(UpdateProductContentRequestDto.toDto(updateProductContentRequestVo));
		return new BaseResponse<>();
	}
}
