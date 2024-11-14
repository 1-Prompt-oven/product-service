package org.example.productservice.seller.product.application;

import org.example.productservice.common.product.domain.Product;
import org.example.productservice.global.common.response.BaseResponseStatus;
import org.example.productservice.global.error.BaseException;
import org.example.productservice.seller.product.dto.in.AddProductPolicyRequestDto;
import org.example.productservice.seller.product.infrastructure.SellerProductContentRepository;
import org.example.productservice.seller.product.infrastructure.SellerProductPolicyRepository;
import org.example.productservice.seller.product.infrastructure.SellerProductRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class SellerProductPolicyServiceImpl implements SellerProductPolicyService {

	private final SellerProductPolicyRepository sellerProductContePolicyRepository;
	private final SellerProductRepository sellerProductRepository;

	@Override
	public void addProductPolicy(AddProductPolicyRequestDto addProductPolicyRequestDto) {

		Product product = sellerProductRepository.findByProductUuid(addProductPolicyRequestDto.getProductUuid())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		sellerProductContePolicyRepository.save(addProductPolicyRequestDto.createProductPolicy(product.getProductUuid()));
	}
}
