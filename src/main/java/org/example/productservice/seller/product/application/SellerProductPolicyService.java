package org.example.productservice.seller.product.application;

import org.example.productservice.common.product.domain.ProductPolicy;
import org.example.productservice.seller.product.dto.in.AddProductPolicyRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerProductPolicyService extends JpaRepository<ProductPolicy, Long> {

	void addProductPolicy(AddProductPolicyRequestDto addProductPolicyRequestDto);
}
