package org.example.productservice.seller.product.presentation;

import org.example.productservice.global.common.response.BaseResponse;
import org.example.productservice.seller.product.application.SellerProductService;
import org.example.productservice.seller.product.dto.in.AddProductRequestDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "판매자 상품 이미지 API", description = "판매자 상품 이미지 관련 API endpoints")
@RequestMapping("/seller/product/content")
public class SellerProductContentController {

	private final Seller

	@Operation(summary = "상품 이미지 등록")
	public BaseResponse<Void> addProductContent(AddProductRequestDto addProductRequestDto) {

		sellerProductService.addProduct(addProductRequestDto);
		return new BaseResponse<>();
	}

	public BaseResponse<Void>
}
