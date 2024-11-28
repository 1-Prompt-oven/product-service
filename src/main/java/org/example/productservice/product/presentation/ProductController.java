package org.example.productservice.product.presentation;

import java.util.List;

import org.example.productservice.common.response.BaseResponse;
import org.example.productservice.product.application.ProductService;
import org.example.productservice.product.dto.in.GetProductListRequestDto;
import org.example.productservice.product.mapper.ProductMapper;
import org.example.productservice.product.vo.in.AddProductRequestVo;
import org.example.productservice.product.vo.in.UpdateProductRequestVo;
import org.example.productservice.product.vo.out.GetProductDetailResponseVo;
import org.example.productservice.product.vo.out.GetProductListResponseVo;
import org.example.productservice.product.vo.out.GetSellerUuidByProductUuidResponseVo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
@Tag(name = "판매자 상품 API", description = "판매자 상품 관련 API endpoints")
public class ProductController {

	private final ProductService productService;
	private final ProductMapper productMapper;

	@Operation(summary = "상품 등록", description = """
	상품 등록
	
	- llmId: (Dall-E, 1), (GPT, 2)
	
	contents는 리스트 형태로 여러 개 등록 가능.
	""")
	@PostMapping("/seller/product")
	public BaseResponse<Void> addProduct(@RequestBody AddProductRequestVo addProductRequestVo) {
		productService.addProduct(productMapper.toDto(addProductRequestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "상품 수정", description = "상품 수정")
	@PutMapping("/seller/product")
	public BaseResponse<Void> updateProduct(@RequestBody UpdateProductRequestVo updateProductRequestVo) {
		productService.updateProduct(productMapper.toDto(updateProductRequestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "상품 삭제", description = "상품 삭제")
	@DeleteMapping("/seller/product/{productUuid}")
	public BaseResponse<Void> deleteProduct(@PathVariable String productUuid) {
		productService.deleteProduct(productUuid);
		return new BaseResponse<>();
	}

	@Operation(summary = "상품 상세 조회", description = "상품 상세 조회")
	@GetMapping("/product/{productUuid}")
	public BaseResponse<GetProductDetailResponseVo> getProductDetail(@PathVariable String productUuid) {

		return new BaseResponse<>(
			productMapper.toVo(productService.getProductDetail(productUuid))
		);
	}

	@Operation(summary = "상품 판매자 조회", description = "상품 판매자 조회")
	@GetMapping("/product/{productUuid}/seller")
	public BaseResponse<GetSellerUuidByProductUuidResponseVo> getSellerUuidByProductUuid(@PathVariable String productUuid) {

		return new BaseResponse<>(
			productMapper.toVo(productService.getSellerUuidByProductUuid(productUuid))
		);
	}

	@Operation(summary = "상품 목록 보기", description = "상품 목록 보기")
	@GetMapping("/product/list")
	public BaseResponse<GetProductListResponseVo> searchProducts(
		@RequestParam(required = false) String searchBar,
		@RequestParam(required = false) String topCategoryUuid,
		@RequestParam(required = false) String subCategoryUuid,
		@RequestParam(required = false) Boolean enable,
		@RequestParam(required = false, defaultValue = "0") String minPrice,
		@RequestParam(required = false) String maxPrice,

		@Parameter(
			description = "정렬 기준 likeCount, avgStar, sells, createdAt"
		)
		@RequestParam(required = false, defaultValue = "CREATED_AT") String sortOption,

		@Parameter(
			description = "정렬 방향 ASC, DESC"
		)
		@RequestParam(required = false, defaultValue = "DESC") String sortBy,

		@RequestParam(required = false) String cursorId,
		@RequestParam(required = false, defaultValue = "20") Integer pageSize,
		@RequestParam(required = false) List<Long> llmIdList
	) {

		GetProductListRequestDto getProductListRequestDto = GetProductListRequestDto.builder()
			.searchBar(searchBar)
			.topCategoryUuid(topCategoryUuid)
			.subCategoryUuid(subCategoryUuid)
			.enable(enable)
			.minPrice(minPrice)
			.maxPrice(maxPrice)
			.sortOption(sortOption)
			.sortBy(sortBy)
			.cursorId(cursorId)
			.pageSize(pageSize)
			.llmIdList(llmIdList)
			.build();

		log.info("sortOption: {}", sortOption);

		return new BaseResponse<>(
			productMapper.toVo(productService.searchProducts(getProductListRequestDto))
		);
	}

}
