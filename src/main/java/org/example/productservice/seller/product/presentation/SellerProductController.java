package org.example.productservice.seller.product.presentation;

import org.example.productservice.global.common.response.BaseResponse;
import org.example.productservice.seller.product.application.SellerProductService;
import org.example.productservice.seller.product.dto.in.AddProductRequestDto;
import org.example.productservice.seller.product.dto.in.DeleteProductRequestDto;
import org.example.productservice.seller.product.dto.in.GetProductDetailRequestDto;
import org.example.productservice.seller.product.dto.in.UpdateProductRequestDto;
import org.example.productservice.seller.product.vo.in.AddProductRequestVo;
import org.example.productservice.seller.product.vo.in.DeleteProductRequestVo;
import org.example.productservice.seller.product.vo.in.GetProductDetailRequestVo;
import org.example.productservice.seller.product.vo.in.UpdateProductRequestVo;
import org.example.productservice.seller.product.vo.out.GetProductDetailResponseVo;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/v1/seller/product")
@Tag(name = "판매자 상품 API", description = "판매자 상품 관련 API endpoints")
public class SellerProductController {

	private final SellerProductService sellerProductService;

	@Operation(summary = "상품 등록", description = """
	상품 등록
	
	- llmName, llmId: (Dall-E, 1), (GPT, 2), (Midjourney, 3)
	""")
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

	@Operation(summary = "상품 삭제", description = "상품 삭제")
	@DeleteMapping
	public BaseResponse<Void> deleteProduct(@RequestBody DeleteProductRequestVo deleteProductRequestVo) {
		sellerProductService.deleteProduct(DeleteProductRequestDto.toDto(deleteProductRequestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "상품 상세 조회", description = "상품 상세 조회")
	@PostMapping("/detail")
	public BaseResponse<GetProductDetailResponseVo> getProductDetail(@RequestBody GetProductDetailRequestVo getProductDetailRequestVo) {
		GetProductDetailRequestDto getProductDetailRequestDto = GetProductDetailRequestDto.toDto(getProductDetailRequestVo);
		return new BaseResponse<>(
			sellerProductService.getProductDetail(getProductDetailRequestDto)
			.toVo()
		);
	}

}
