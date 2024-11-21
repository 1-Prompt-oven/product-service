package org.example.productservice.product.presentation;

import org.example.productservice.common.response.BaseResponse;
import org.example.productservice.product.application.ProductService;
import org.example.productservice.product.mapper.ProductMapper;
import org.example.productservice.product.vo.in.AddProductRequestVo;
import org.example.productservice.product.vo.in.UpdateProductRequestVo;
import org.example.productservice.product.vo.out.GetProductDetailResponseVo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class ProductController {

	private final ProductService productService;
	private final ProductMapper productMapper;

	@Operation(summary = "상품 등록", description = """
	상품 등록
	
	- llmId: (Dall-E, 1), (GPT, 2)
	
	contents는 리스트 형태로 여러 개 등록 가능.
	""")
	@PostMapping
	public BaseResponse<Void> addProduct(@RequestBody AddProductRequestVo addProductRequestVo) {
		productService.addProduct(productMapper.toDto(addProductRequestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "상품 수정", description = "상품 수정")
	@PutMapping
	public BaseResponse<Void> updateProduct(@RequestBody UpdateProductRequestVo updateProductRequestVo) {
		productService.updateProduct(productMapper.toDto(updateProductRequestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "상품 삭제", description = "상품 삭제")
	@DeleteMapping("/{productUuid}")
	public BaseResponse<Void> deleteProduct(@PathVariable String productUuid) {
		productService.deleteProduct(productUuid);
		return new BaseResponse<>();
	}

	@Operation(summary = "상품 상세 조회", description = "상품 상세 조회")
	@GetMapping("/{productUuid}")
	public BaseResponse<GetProductDetailResponseVo> getProductDetail(@PathVariable String productUuid) {

		return new BaseResponse<>(
			productMapper.toVo(productService.getProductDetail(productUuid))
		);
	}

}
