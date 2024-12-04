package org.example.productservice.product.application;

import java.util.List;

import org.example.productservice.common.error.BaseException;
import org.example.productservice.common.response.BaseResponseStatus;
import org.example.productservice.common.utils.Encrypter;
import org.example.productservice.product.domain.Product;
import org.example.productservice.product.dto.in.AddProductRequestDto;
import org.example.productservice.product.dto.in.GetProductListRequestDto;
import org.example.productservice.product.dto.in.UpdateProductRequestDto;
import org.example.productservice.product.dto.message.GetProductListResponseDto;
import org.example.productservice.product.dto.out.GetProductDetailResponseDto;
import org.example.productservice.product.dto.out.GetSellerUuidByProductUuidResponseDto;
import org.example.productservice.product.dto.out.GetTemporaryProductListResponseDto;
import org.example.productservice.product.dto.out.ProductDto;
import org.example.productservice.product.dto.out.TemporaryAddProductResponseDto;
import org.example.productservice.product.infrastructure.CustomProductRepository;
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
	private final CustomProductRepository customProductRepository;
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

		String encryptedPrompt = encrypter.encrypt(updateProductRequestDto.getPrompt())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.ENCRYPTION_ERROR));

		productRepository.save(productMapper.updateProduct(product, encryptedPrompt, updateProductRequestDto));
	}

	@Override
	public void deleteProduct(String productUuid) {

		Product product = productRepository.findByProductUuid(productUuid)
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		String encryptedPrompt = encrypter.encrypt(product.getPrompt())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.ENCRYPTION_ERROR));

		productRepository.save(productMapper.deleteProduct(product, encryptedPrompt));
	}

	@Override
	public GetProductDetailResponseDto getProductDetail(String productUuid) {

		Product product = productRepository.findByProductUuid(productUuid)
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		String prompt = encrypter.decrypt(product.getPrompt())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.DECRYPTION_ERROR));

		return productMapper.toDto(product, prompt);
	}

	@Override
	public GetSellerUuidByProductUuidResponseDto getSellerUuidByProductUuid(String productUuid) {

		Product product = productRepository.findByProductUuid(productUuid)
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		return productMapper.toSellerUuidDto(product);
	}

	@Override
	public GetProductListResponseDto searchProducts(GetProductListRequestDto getProductListRequestDto) {

		int pageSize = getProductListRequestDto.getPageSize();

		// 페이지 사이즈 + 1개를 조회하여 다음 페이지 존재 여부 확인
		List<Product> products = customProductRepository.findProductListWithCursor(getProductListRequestDto, pageSize + 1);

		boolean hasNext = products.size() > pageSize;
		if (hasNext) {
			products = products.subList(0, pageSize);
		}

		List<ProductDto> productDtoLists = products.stream()
			.map(productMapper::productToDto)
			.toList();

		String nextCursorId = hasNext ? products.getLast().getId() : null;

		return GetProductListResponseDto.builder()
			.productList(productDtoLists)
			.nextCursorId(nextCursorId)
			.hasNext(hasNext)
			.build();
	}

	@Override
	public TemporaryAddProductResponseDto temporaryAddProduct(AddProductRequestDto addProductRequestDto) {
		String encryptedPrompt = encrypter.encrypt(addProductRequestDto.getPrompt())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.ENCRYPTION_ERROR));

		Product product = productRepository.save(productMapper.temporaryCreateProduct(addProductRequestDto, encryptedPrompt));

		return TemporaryAddProductResponseDto.builder()
			.productUuid(product.getProductUuid())
			.build();
	}

	@Override
	public List<GetTemporaryProductListResponseDto> getTemporaryProductList(String memberUuid) {

		return productRepository.findTemporaryProductList(memberUuid)
			.stream()
			.map(productMapper::temporaryProductToDto)
			.toList();
	}

}
