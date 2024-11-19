package org.example.productservice.product.application;

import java.util.List;

import org.example.productservice.product.dto.out.GetProductContentResponseDto;
import org.example.productservice.product.infrastructure.ProductContentRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommonProductServiceImpl implements CommonProductService {

	private final ProductContentRepository productContentRepository;

	@Override
	public List<GetProductContentResponseDto> getProductContentList(String productUuid) {

		return productContentRepository.findContentListByProductUuid(productUuid)
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
