package org.example.productservice.seller.product.application;

import org.example.productservice.global.common.response.BaseResponseStatus;
import org.example.productservice.global.error.BaseException;
import org.example.productservice.seller.product.dto.UpdateProductPolicyRequestDto;
import org.example.productservice.seller.product.dto.in.AddProductPolicyRequestDto;
import org.example.productservice.seller.product.infrastructure.SellerProductPolicyRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class SellerProductPolicyServiceImpl implements SellerProductPolicyService {

	private final SellerProductPolicyRepository sellerProductPolicyRepository;

	@Override
	public void addProductPolicy(AddProductPolicyRequestDto addProductPolicyRequestDto) {

		if (sellerProductPolicyRepository.existsByProductUuid(addProductPolicyRequestDto.getProductUuid())) {
			throw new BaseException(BaseResponseStatus.DUPLICATED_DATA);
		}

		sellerProductPolicyRepository.save(addProductPolicyRequestDto
			.createProductPolicy(addProductPolicyRequestDto.getProductUuid()));
	}

	@Override
	public void updateProductPolicy(UpdateProductPolicyRequestDto updateProductPolicyRequestDto) {

		Long productPolicyId = sellerProductPolicyRepository
			.findByProductUuid(updateProductPolicyRequestDto.getProductUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA))
			.getProductPolicyId();

		sellerProductPolicyRepository.save(updateProductPolicyRequestDto
			.updateProductPolicy(productPolicyId));
	}
}
