package org.example.productservice.product.presentation;

import org.example.productservice.common.response.BaseResponse;
import org.example.productservice.product.application.ProductService;
import org.example.productservice.product.dto.in.AddProductRequestDto;
import org.example.productservice.product.vo.in.AddProductRequestVo;
import org.springframework.web.bind.annotation.PostMapping;
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
public class ProductController {

	private final ProductService productService;

	@Operation(summary = "상품 등록", description = """
	상품 등록
	
	- llmId: (Dall-E, 1), (GPT, 2)
	""")
	@PostMapping
	public BaseResponse<Void> addProduct(@RequestBody AddProductRequestVo addProductRequestVo) {
		productService.addProduct(AddProductRequestDto.toDto(addProductRequestVo));
		return new BaseResponse<>();
	}

	// @Operation(summary = "상품 수정", description = "상품 수정")
	// @PutMapping
	// public BaseResponse<Void> updateProduct(@RequestBody UpdateProductRequestVo updateProductRequestVo) {
	// 	productService.updateProduct(UpdateProductRequestDto.toDto(updateProductRequestVo));
	// 	return new BaseResponse<>();
	// }
	//
	// @Operation(summary = "상품 삭제", description = "상품 삭제")
	// @PutMapping("/delete")
	// public BaseResponse<Void> deleteProduct(@RequestBody DeleteProductRequestVo deleteProductRequestVo) {
	// 	productService.deleteProduct(DeleteProductRequestDto.toDto(deleteProductRequestVo));
	// 	return new BaseResponse<>();
	// }

}
