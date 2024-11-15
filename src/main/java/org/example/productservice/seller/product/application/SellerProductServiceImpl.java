package org.example.productservice.seller.product.application;

import org.example.productservice.common.product.domain.Product;
import org.example.productservice.global.common.response.BaseResponseStatus;
import org.example.productservice.global.error.BaseException;
import org.example.productservice.seller.product.dto.in.AddProductRequestDto;
import org.example.productservice.seller.product.dto.in.DeleteProductRequestDto;
import org.example.productservice.seller.product.dto.in.GetProductDetailRequestDto;
import org.example.productservice.seller.product.dto.in.UpdateProductRequestDto;
import org.example.productservice.seller.product.dto.out.GetProductDetailResponseDto;
import org.example.productservice.seller.product.infrastructure.SellerProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class SellerProductServiceImpl implements SellerProductService {

	private final SellerProductRepository sellerProductRepository;

	@Override
	public void addProduct(AddProductRequestDto addProductRequestDto) {

		if (sellerProductRepository.existsByProductName(addProductRequestDto.getProductName())) {
			throw new BaseException(BaseResponseStatus.DUPLICATED_DATA);
		}

		sellerProductRepository.save(addProductRequestDto.createProduct());
	}

	@Override
	public void updateProduct(UpdateProductRequestDto updateProductRequestDto) {

		Long productId = sellerProductRepository.findByProductUuid(updateProductRequestDto.getProductUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA))
			.getProductId();

		sellerProductRepository.save(updateProductRequestDto.updateProduct(productId));
	}

	@Override
	public void deleteProduct(DeleteProductRequestDto deleteProductRequestDto) {

		Product product = sellerProductRepository.findByProductUuid(deleteProductRequestDto.getProductUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		sellerProductRepository.save(deleteProductRequestDto.deleteProduct(product));
	}

	@Transactional(readOnly = true)
	@Override
	public GetProductDetailResponseDto getProductDetail(GetProductDetailRequestDto getProductDetailRequestDto) {

		Product product = sellerProductRepository.findByProductUuid(getProductDetailRequestDto.getProductUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		return GetProductDetailResponseDto.toDto(product);
	}

}
