package org.example.productservice.product.presentation;

import org.example.productservice.common.response.BaseResponse;
import org.example.productservice.product.application.ProductPolicyService;
import org.example.productservice.product.dto.UpdateProductPolicyRequestDto;
import org.example.productservice.product.dto.in.AddProductPolicyRequestDto;
import org.example.productservice.product.dto.in.DeleteProductPolicyRequestDto;
import org.example.productservice.product.vo.UpdateProductPolicyRequestVo;
import org.example.productservice.product.vo.in.AddProductPolicyRequestVo;
import org.example.productservice.product.vo.in.DeleteProductContentRequestVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "판매자 상품 정책 API", description = "판매자 상품 정책 관련 API endpoints")
@RequestMapping("/v1/seller/product/policy")
public class ProductPolicyController {

	private final ProductPolicyService productPolicyService;

	@Operation(summary = "상품 정책 등록", description = """
		""")
	@PostMapping
	public BaseResponse<Void> addProductPolicy(AddProductPolicyRequestVo addProductPolicyRequestVo) {

		productPolicyService.addProductPolicy(
			AddProductPolicyRequestDto.toDto(addProductPolicyRequestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "상품 정책 수정", description = """
		""")
	@PutMapping
	public BaseResponse<Void> updateProductPolicy(UpdateProductPolicyRequestVo updateProductPolicyRequestVo) {

		productPolicyService.updateProductPolicy(
			UpdateProductPolicyRequestDto.toDto(updateProductPolicyRequestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "상품 정책 삭제", description = """
		""")
	@PutMapping("/delete")
	public BaseResponse<Void> deleteProductPolicy(DeleteProductContentRequestVo deleteProductContentRequestVo) {

		productPolicyService.deleteProductPolicy(DeleteProductPolicyRequestDto.toDto(deleteProductContentRequestVo));
		return new BaseResponse<>();
	}
}
