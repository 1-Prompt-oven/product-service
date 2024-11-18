package org.example.productservice.seller.product.application;

import java.util.List;

import org.example.productservice.common.product.domain.ProductContent;
import org.example.productservice.global.common.response.BaseResponseStatus;
import org.example.productservice.global.error.BaseException;
import org.example.productservice.seller.product.dto.in.AddProductContentRequestDto;
import org.example.productservice.seller.product.dto.in.UpdateProductContentRequestDto;
import org.example.productservice.seller.product.dto.out.GetProductContentResponseDto;
import org.example.productservice.seller.product.infrastructure.SellerProductContentRepository;
import org.example.productservice.seller.product.infrastructure.SellerProductRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class SellerProductContentServiceImpl implements SellerProductContentService {

	private final SellerProductContentRepository sellerProductContentRepository;
	private final SellerProductRepository sellerProductRepository;

	@Override
	public void addProductContent(AddProductContentRequestDto addProductContentRequestDto) {

		if (sellerProductRepository.existsByProductUuid(addProductContentRequestDto.getProductUuid())) {
			throw new BaseException(BaseResponseStatus.DUPLICATED_DATA);
		}

		sellerProductContentRepository.save(addProductContentRequestDto.createProductContent());
	}

	@Override
	public void updateProductContent(UpdateProductContentRequestDto updateProductContentRequestDto) {

		Long productContentId = sellerProductContentRepository.findByProductContentUuid(updateProductContentRequestDto.getProductContentUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA))
			.getProductContentId();

		sellerProductContentRepository.save(updateProductContentRequestDto.updateProductContent(productContentId));
	}

	@Override
	public void deleteProductContent(String productContentUuid) {

		ProductContent productContent = sellerProductContentRepository.findByProductContentUuid(productContentUuid)
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		sellerProductContentRepository.save(ProductContent.builder()
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

	@Override
	public List<GetProductContentResponseDto> getProductContentList(String productUuid) {

		return sellerProductContentRepository.findContentListByProductUuid(productUuid)
			.stream()
			.filter(productContent -> !productContent.isDeleted())
			.map(productContent -> GetProductContentResponseDto.builder()
				.productContentUuid(productContent.getProductContentUuid())
				.productUuid(productContent.getProductUuid())
				.contentUrl(productContent.getContentUrl())
				.order(productContent.getContentOrder())
				.sampleValue(productContent.getSampleValue())
				.build())
			.toList();
	}
}
