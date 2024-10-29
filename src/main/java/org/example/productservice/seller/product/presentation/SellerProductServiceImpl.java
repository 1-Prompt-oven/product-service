package org.example.productservice.seller.product.presentation;

import org.example.productservice.common.domain.Product;
import org.example.productservice.common.domain.ProductPolicy;
import org.example.productservice.global.common.response.BaseResponseStatus;
import org.example.productservice.global.error.BaseException;
import org.example.productservice.seller.product.dto.in.AddProductRequestDto;
import org.example.productservice.seller.product.dto.in.DeleteProductRequestDto;
import org.example.productservice.seller.product.dto.in.GetProductDetailRequestDto;
import org.example.productservice.seller.product.dto.out.GetProductDetailResponseDto;
import org.example.productservice.seller.product.infrastructure.SellerProductPolicyRepository;
import org.example.productservice.seller.product.infrastructure.SellerProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class SellerProductServiceImpl implements SellerProductService {

	private final SellerProductRepository sellerProductRepository;
	private final SellerProductPolicyRepository sellerProductPolicyRepository;

	@Override
	public void addProduct(AddProductRequestDto addProductRequestDto) {
		// 하나의 트랜젝션으로 처리하여 롤백이 가능하도록 함
		Product product = sellerProductRepository.save(addProductRequestDto.createProduct());
		sellerProductPolicyRepository.save(addProductRequestDto.createProductPolicy(product));
	}

	@Override
	public void updateProduct(Long productUuid, AddProductRequestDto addProductRequestDto) {

		sellerProductRepository.findById(productUuid)
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		Product updatedProduct = addProductRequestDto.updateProduct(productUuid);
		addProductRequestDto.updateProductPolicy(updatedProduct);
	}

	@Override
	public void deleteProduct(DeleteProductRequestDto deleteProductRequestDto) {

		Product product = sellerProductRepository.findByUuid(deleteProductRequestDto.getProductUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		ProductPolicy productPolicy = sellerProductPolicyRepository.findByProduct(product)
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		sellerProductPolicyRepository.save(deleteProductRequestDto.deleteProduct(productPolicy));
	}

	@Transactional(readOnly = true)
	@Override
	public GetProductDetailResponseDto getProductDetail(GetProductDetailRequestDto getProductDetailRequestDto) {

		Product product = sellerProductRepository.findByUuid(getProductDetailRequestDto.getProductUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		ProductPolicy productPolicy = sellerProductPolicyRepository.findByProduct(product)
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		return GetProductDetailResponseDto.toDto(product, productPolicy);
	}

}
