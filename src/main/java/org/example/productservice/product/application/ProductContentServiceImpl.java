package org.example.productservice.product.application;

import org.example.productservice.common.error.BaseException;
import org.example.productservice.common.response.BaseResponseStatus;
import org.example.productservice.product.domain.ProductContent;
import org.example.productservice.product.dto.in.AddProductContentRequestDto;
import org.example.productservice.product.dto.in.UpdateProductContentRequestDto;
import org.example.productservice.product.infrastructure.ProductContentRepository;
import org.example.productservice.product.infrastructure.ProductRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductContentServiceImpl implements ProductContentService {

	private final ProductContentRepository productContentRepository;
	private final ProductRepository productRepository;

	@Override
	public void addProductContent(AddProductContentRequestDto addProductContentRequestDto) {

		if (productRepository.existsByProductUuid(addProductContentRequestDto.getProductUuid())) {
			throw new BaseException(BaseResponseStatus.DUPLICATED_DATA);
		}

		productContentRepository.save(addProductContentRequestDto.createProductContent());
	}

	@Override
	public void updateProductContent(UpdateProductContentRequestDto updateProductContentRequestDto) {

		Long productContentId = productContentRepository.findByProductContentUuid(updateProductContentRequestDto.getProductContentUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA))
			.getProductContentId();

		productContentRepository.save(updateProductContentRequestDto.updateProductContent(productContentId));
	}

	@Override
	public void deleteProductContent(String productContentUuid) {

		ProductContent productContent = productContentRepository.findByProductContentUuid(productContentUuid)
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		productContentRepository.save(ProductContent.builder()
			.productContentId(productContent.getProductContentId())
			.productContentUuid(productContent.getProductContentUuid())
			.productUuid(productContent.getProductUuid())
			.contentUrl(productContent.getContentUrl())
			.contentOrder(productContent.getContentOrder())
			.sampleValue(productContent.getSampleValue())
			.deleted(true)
			.build()
		);
	}


}
