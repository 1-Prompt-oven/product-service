package org.example.productservice.product.presentation;

import org.example.productservice.common.response.BaseResponse;
import org.example.productservice.product.application.SellerProductPolicyService;
import org.example.productservice.product.dto.UpdateProductPolicyRequestDto;
import org.example.productservice.product.dto.in.AddProductPolicyRequestDto;
import org.example.productservice.product.vo.UpdateProductPolicyRequestVo;
import org.example.productservice.product.vo.in.AddProductPolicyRequestVo;
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
public class SellerProductPolicyController {

	private final SellerProductPolicyService sellerProductPolicyService;

	@Operation(summary = "상품 정책 등록", description = """
		""")
	@PostMapping
	public BaseResponse<Void> addProductPolicy(AddProductPolicyRequestVo addProductPolicyRequestVo) {

		sellerProductPolicyService.addProductPolicy(
			AddProductPolicyRequestDto.toDto(addProductPolicyRequestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "상품 정책 수정", description = """
		""")
	@PutMapping
	public BaseResponse<Void> updateProductPolicy(UpdateProductPolicyRequestVo updateProductPolicyRequestVo) {

		sellerProductPolicyService.updateProductPolicy(
			UpdateProductPolicyRequestDto.toDto(updateProductPolicyRequestVo));
		return new BaseResponse<>();
	}
}
