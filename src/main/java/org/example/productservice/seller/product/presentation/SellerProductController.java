package org.example.productservice.seller.product.presentation;

import org.example.productservice.global.common.response.BaseResponse;
import org.example.productservice.seller.product.application.SellerProductService;
import org.example.productservice.seller.product.dto.in.AddProductRequestDto;
import org.example.productservice.seller.product.dto.in.UpdateProductRequestDto;
import org.example.productservice.seller.product.vo.in.UpdateProductRequestVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/seller/product")
@Tag(name = "판매자 상품 API", description = "판매자 상품 관련 API endpoints")
public class SellerProductController {

	private final SellerProductService sellerProductService;

	@Operation(summary = "상품 등록", description = "상품 등록")
	@PostMapping
	public BaseResponse<Void> addProduct(@RequestBody AddProductRequestVo addProductRequestVo) {
		sellerProductService.addProduct(AddProductRequestDto.toDto(addProductRequestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "상품 수정", description = "상품 수정")
	@PutMapping
	public BaseResponse<Void> updateProduct(@RequestBody UpdateProductRequestVo updateProductRequestVo) {
		sellerProductService.updateProduct(UpdateProductRequestDto.toDto(updateProductRequestVo));
		return new BaseResponse<>();
	}

}
