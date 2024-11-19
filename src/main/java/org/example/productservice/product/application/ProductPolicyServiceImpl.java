package org.example.productservice.product.application;

import org.example.productservice.common.error.BaseException;
import org.example.productservice.common.response.BaseResponseStatus;
import org.example.productservice.product.domain.ProductPolicy;
import org.example.productservice.product.dto.UpdateProductPolicyRequestDto;
import org.example.productservice.product.dto.in.AddProductPolicyRequestDto;
import org.example.productservice.product.dto.in.DeleteProductPolicyRequestDto;
import org.example.productservice.product.infrastructure.ProductPolicyRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductPolicyServiceImpl implements ProductPolicyService {

	private final ProductPolicyRepository productPolicyRepository;

	@Override
	public void addProductPolicy(AddProductPolicyRequestDto addProductPolicyRequestDto) {

		productPolicyRepository.save(addProductPolicyRequestDto
			.createEntity(addProductPolicyRequestDto.getProductUuid()));
	}

	@Override
	public void updateProductPolicy(UpdateProductPolicyRequestDto updateProductPolicyRequestDto) {

		ProductPolicy productPolicy = productPolicyRepository
			.findByProductUuid(updateProductPolicyRequestDto.getProductUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		productPolicyRepository.save(updateProductPolicyRequestDto
			.updateProductPolicy(productPolicy, updateProductPolicyRequestDto));
	}

	@Override
	public void deleteProductPolicy(DeleteProductPolicyRequestDto deleteProductPolicyRequestDto) {

		ProductPolicy productPolicy = productPolicyRepository
			.findByProductUuid(deleteProductPolicyRequestDto.getProductPolicyUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		productPolicyRepository.save(deleteProductPolicyRequestDto.deleteEntity(productPolicy));
	}
}
