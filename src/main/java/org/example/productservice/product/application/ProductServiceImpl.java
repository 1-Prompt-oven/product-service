package org.example.productservice.product.application;

import org.example.productservice.common.error.BaseException;
import org.example.productservice.common.response.BaseResponseStatus;
import org.example.productservice.product.domain.Product;
import org.example.productservice.product.dto.in.AddProductRequestDto;
import org.example.productservice.product.dto.in.DeleteProductRequestDto;
import org.example.productservice.product.dto.in.UpdateProductRequestDto;
import org.example.productservice.product.infrastructure.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Override
	public void addProduct(AddProductRequestDto addProductRequestDto) {

		if (productRepository.existsByProductName(addProductRequestDto.getProductName())) {
			throw new BaseException(BaseResponseStatus.DUPLICATED_DATA);
		}

		productRepository.save(addProductRequestDto.createProduct());
	}

	@Override
	public void updateProduct(UpdateProductRequestDto updateProductRequestDto) {

		Long productId = productRepository.findByProductUuid(updateProductRequestDto.getProductUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA))
			.getProductId();

		productRepository.save(updateProductRequestDto.updateProduct(productId));
	}

	@Override
	public void deleteProduct(DeleteProductRequestDto deleteProductRequestDto) {

		Product product = productRepository.findByProductUuid(deleteProductRequestDto.getProductUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		productRepository.save(deleteProductRequestDto.deleteProduct(product));
	}

	// @Transactional(readOnly = true)
	// @Override
	// public GetProductDetailResponseDto getProductDetail(GetProductDetailRequestDto getProductDetailRequestDto) {
	//
	// 	Product product = productRepository.findByProductUuid(getProductDetailRequestDto.getProductUuid())
	// 		.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));
	//
	// 	return GetProductDetailResponseDto.toDto(product);
	// }

}
