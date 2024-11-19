package org.example.productservice.product.application;

import org.example.productservice.common.response.BaseResponseStatus;
import org.example.productservice.common.error.BaseException;
import org.example.productservice.product.dto.UpdateProductPolicyRequestDto;
import org.example.productservice.product.dto.in.AddProductPolicyRequestDto;
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

		if (productPolicyRepository.existsByProductUuid(addProductPolicyRequestDto.getProductUuid())) {
			throw new BaseException(BaseResponseStatus.DUPLICATED_DATA);
		}

		productPolicyRepository.save(addProductPolicyRequestDto
			.createProductPolicy(addProductPolicyRequestDto.getProductUuid()));
	}

	@Override
	public void updateProductPolicy(UpdateProductPolicyRequestDto updateProductPolicyRequestDto) {

		Long productPolicyId = productPolicyRepository
			.findByProductUuid(updateProductPolicyRequestDto.getProductUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA))
			.getProductPolicyId();

		productPolicyRepository.save(updateProductPolicyRequestDto
			.updateProductPolicy(productPolicyId));
	}
}
