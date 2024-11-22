package org.example.productservice.product.application;

import org.example.productservice.product.dto.in.AddProductRequestDto;
import org.example.productservice.product.dto.in.UpdateProductRequestDto;
import org.example.productservice.product.dto.out.GetProductDetailResponseDto;
import org.example.productservice.product.dto.out.GetSellerUuidByProductUuidResponseDto;

public interface ProductService {

	void addProduct(AddProductRequestDto addProductRequestDto);
	void updateProduct(UpdateProductRequestDto updateProductRequestDto);
	void deleteProduct(String productUuid);
	GetProductDetailResponseDto getProductDetail(String productUuid);
	GetSellerUuidByProductUuidResponseDto getSellerUuidByProductUuid(String productUuid);
}
