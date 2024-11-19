package org.example.productservice.product.application;

import org.example.productservice.product.dto.UpdateProductPolicyRequestDto;
import org.example.productservice.product.dto.in.AddProductPolicyRequestDto;
import org.example.productservice.product.dto.in.DeleteProductPolicyRequestDto;

public interface ProductPolicyService {

	void addProductPolicy(AddProductPolicyRequestDto addProductPolicyRequestDto);
	void updateProductPolicy(UpdateProductPolicyRequestDto updateProductPolicyRequestDto);
	void deleteProductPolicy(DeleteProductPolicyRequestDto deleteProductPolicyRequestDto);
}
