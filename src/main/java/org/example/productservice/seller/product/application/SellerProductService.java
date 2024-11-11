package org.example.productservice.seller.product.application;

import org.example.productservice.seller.product.dto.in.AddProductContentRequestDto;
import org.example.productservice.seller.product.dto.in.AddProductPolicyRequestDto;
import org.example.productservice.seller.product.dto.in.AddProductRequestDto;
import org.example.productservice.seller.product.dto.in.DeleteProductRequestDto;
import org.example.productservice.seller.product.dto.in.GetProductDetailRequestDto;
import org.example.productservice.seller.product.dto.in.UpdateProductRequestDto;
import org.example.productservice.seller.product.dto.out.GetProductDetailResponseDto;

public interface SellerProductService {

	void addProduct(AddProductRequestDto addProductRequestDto);
	void addProductPolicy(AddProductPolicyRequestDto addProductPolicyRequestDto);
	void addProductContent(AddProductContentRequestDto addProductContentRequestDto);
	void updateProduct(UpdateProductRequestDto updateProductRequestDto);
	void deleteProduct(DeleteProductRequestDto deleteProductRequestDto);
	GetProductDetailResponseDto getProductDetail(GetProductDetailRequestDto getProductDetailRequestDto);
}
