package org.example.productservice.seller.product.application;

import org.example.productservice.common.product.domain.Product;
import org.example.productservice.common.product.domain.ProductContent;
import org.example.productservice.common.product.domain.ProductPolicy;
import org.example.productservice.global.common.response.BaseResponseStatus;
import org.example.productservice.global.error.BaseException;
import org.example.productservice.seller.product.dto.in.AddProductContentRequestDto;
import org.example.productservice.seller.product.dto.in.AddProductRequestDto;
import org.example.productservice.seller.product.dto.in.DeleteProductRequestDto;
import org.example.productservice.seller.product.dto.in.GetProductDetailRequestDto;
import org.example.productservice.seller.product.dto.in.UpdateProductRequestDto;
import org.example.productservice.seller.product.dto.out.GetProductDetailResponseDto;
import org.example.productservice.seller.product.infrastructure.SellerProductContentRepository;
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
	private final SellerProductContentRepository sellerProductContentRepository;

	@Override
	public void addProduct(AddProductRequestDto addProductRequestDto) {

		if (sellerProductRepository.existsByProductName(addProductRequestDto.getProductName())) {
			throw new BaseException(BaseResponseStatus.DUPLICATED_DATA);
		}

		sellerProductRepository.save(addProductRequestDto.createProduct());
	}

	@Override
	public void updateProduct(UpdateProductRequestDto updateProductRequestDto) {

		Product product = sellerProductRepository.findByProductUuid(updateProductRequestDto.getProductUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		ProductPolicy productPolicy = sellerProductPolicyRepository.findByProductUuid(product.getProductUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		ProductContent productContent = sellerProductContentRepository.findByProductUuid(product.getProductUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		Product updatedProduct = sellerProductRepository.save(updateProductRequestDto.updateProduct(product.getProductId()));
		sellerProductPolicyRepository.save(updateProductRequestDto
			.updateProductPolicy(productPolicy.getProductPolicyId(), updatedProduct.getProductUuid()));

		updateProductRequestDto.getProductContentRequestDto()
			.forEach(productContentRequestDto ->
				sellerProductContentRepository.save(
				updateProductRequestDto.updateProductContent(
					productContent.getProductContentId(), productContentRequestDto)));
	}

	@Override
	public void deleteProduct(DeleteProductRequestDto deleteProductRequestDto) {

		Product product = sellerProductRepository.findByProductUuid(deleteProductRequestDto.getProductUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		ProductPolicy productPolicy = sellerProductPolicyRepository.findByProductUuid(product.getProductUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		sellerProductPolicyRepository.save(deleteProductRequestDto.deleteProduct(productPolicy));
	}

	@Transactional(readOnly = true)
	@Override
	public GetProductDetailResponseDto getProductDetail(GetProductDetailRequestDto getProductDetailRequestDto) {

		Product product = sellerProductRepository.findByProductUuid(getProductDetailRequestDto.getProductUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		ProductPolicy productPolicy = sellerProductPolicyRepository.findByProductUuid(product.getProductUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		return GetProductDetailResponseDto.toDto(product, productPolicy);
	}

}
