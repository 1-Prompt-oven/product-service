package org.example.productservice.seller.product.application;

import org.example.productservice.seller.product.dto.UpdateProductPolicyRequestDto;
import org.example.productservice.seller.product.dto.in.AddProductPolicyRequestDto;

public interface SellerProductPolicyService {

	void addProductPolicy(AddProductPolicyRequestDto addProductPolicyRequestDto);
	void updateProductPolicy(UpdateProductPolicyRequestDto updateProductPolicyRequestDto);
	// 상품 삭제가 곧 정책 삭제이므로 삭제 메서드는 따로 구현하지 않음
}
