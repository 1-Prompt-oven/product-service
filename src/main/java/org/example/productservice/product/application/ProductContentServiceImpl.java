package org.example.productservice.product.application;

import org.example.productservice.common.error.BaseException;
import org.example.productservice.common.response.BaseResponseStatus;
import org.example.productservice.product.domain.ProductContent;
import org.example.productservice.product.dto.in.AddProductContentRequestDto;
import org.example.productservice.product.dto.in.DeleteProductContentRequestDto;
import org.example.productservice.product.dto.in.UpdateProductContentRequestDto;
import org.example.productservice.product.infrastructure.ProductContentRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductContentServiceImpl implements ProductContentService {

	private final ProductContentRepository productContentRepository;

	@Override
	public void addProductContent(AddProductContentRequestDto addProductContentRequestDto) {

		productContentRepository.save(addProductContentRequestDto.createEntity());
	}

	@Override
	public void updateProductContent(UpdateProductContentRequestDto updateProductContentRequestDto) {

		ProductContent productContent = productContentRepository.findByProductContentUuid(updateProductContentRequestDto.getProductContentUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		productContentRepository.save(updateProductContentRequestDto.
			updateEntity(productContent, updateProductContentRequestDto));
	}

	@Override
	public void deleteProductContent(DeleteProductContentRequestDto deleteProductContentRequestDto) {

		ProductContent productContent = productContentRepository.
			findByProductContentUuid(deleteProductContentRequestDto.getProductContentUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		productContentRepository.save(deleteProductContentRequestDto.deleteEntity(productContent));
	}


}
