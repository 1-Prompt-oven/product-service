package org.example.productservice.product.presentation;

import org.example.productservice.common.response.BaseResponse;
import org.example.productservice.product.application.ProductContentService;
import org.example.productservice.product.dto.in.AddProductContentRequestDto;
import org.example.productservice.product.dto.in.DeleteProductContentRequestDto;
import org.example.productservice.product.dto.in.UpdateProductContentRequestDto;
import org.example.productservice.product.vo.in.AddProductContentRequestVo;
import org.example.productservice.product.vo.in.DeleteProductContentRequestVo;
import org.example.productservice.product.vo.in.UpdateProductContentRequestVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "판매자 상품 이미지 API", description = "판매자 상품 이미지 관련 API endpoints")
@RequestMapping("/v1/seller/product/content")
public class ProductContentController {

	private final ProductContentService productContentService;

	@Operation(summary = "상품 콘텐츠 등록", description = """
		contentUrl = 콘텐츠 URL(이미지 URL)
		order = 콘텐츠 순서
		sampleValue = 해당 샘플의 {} 내부 값
		""")
	@PostMapping
	public BaseResponse<Void> addProductContent(AddProductContentRequestVo addProductContentRequestVo) {

		productContentService.addProductContent(AddProductContentRequestDto.toDto(addProductContentRequestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "상품 콘텐츠 수정", description = """
		contentUrl = 콘텐츠 URL(이미지 URL)
		order = 콘텐츠 순서
		sampleValue = 해당 샘플의 {} 내부 값
		""")
	@PutMapping
	public BaseResponse<Void> updateProductContent(UpdateProductContentRequestVo updateProductContentRequestVo) {

		productContentService.updateProductContent(UpdateProductContentRequestDto.toDto(updateProductContentRequestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "상품 콘텐츠 삭제", description = "상품 콘텐츠 삭제")
	@PutMapping("/delete")
	public BaseResponse<Void> deleteProductContent(DeleteProductContentRequestVo deleteProductContentRequestVo) {

		productContentService.deleteProductContent(DeleteProductContentRequestDto.toDto(deleteProductContentRequestVo));
		return new BaseResponse<>();
	}
}
