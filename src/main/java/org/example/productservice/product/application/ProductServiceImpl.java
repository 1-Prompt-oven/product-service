package org.example.productservice.product.application;

import org.example.productservice.common.error.BaseException;
import org.example.productservice.common.response.BaseResponseStatus;
import org.example.productservice.common.utils.Encrypter;
import org.example.productservice.product.domain.Product;
import org.example.productservice.product.dto.in.AddProductRequestDto;
import org.example.productservice.product.dto.in.UpdateProductRequestDto;
import org.example.productservice.product.dto.out.GetProductDetailResponseDto;
import org.example.productservice.product.dto.out.GetSellerUuidByProductUuidResponseDto;
import org.example.productservice.product.infrastructure.ProductRepository;
import org.example.productservice.product.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private final Encrypter encrypter;
	private final ProductMapper productMapper;

	@Override
	public void addProduct(AddProductRequestDto addProductRequestDto) {

		String encryptedPrompt = encrypter.encrypt(addProductRequestDto.getPrompt())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.ENCRYPTION_ERROR));

		productRepository.save(productMapper.createProduct(addProductRequestDto, encryptedPrompt));
	}

	@Override
	public void updateProduct(UpdateProductRequestDto updateProductRequestDto) {

		Product product = productRepository.findByProductUuid(updateProductRequestDto.getProductUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		productRepository.save(productMapper.updateProduct(product, updateProductRequestDto));
	}

	@Override
	public void deleteProduct(String productUuid) {

		Product product = productRepository.findByProductUuid(productUuid)
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		productRepository.save(productMapper.deleteProduct(product));
	}

	@Override
	public GetProductDetailResponseDto getProductDetail(String productUuid) {

		Product product = productRepository.findByProductUuid(productUuid)
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		return productMapper.toDto(product);
	}

	@Override
	public GetSellerUuidByProductUuidResponseDto getSellerUuidByProductUuid(String productUuid) {

		Product product = productRepository.findByProductUuid(productUuid)
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		return productMapper.toSellerUuidDto(product);
	}

}
