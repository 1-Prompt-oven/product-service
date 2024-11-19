package org.example.productservice.product.application;

import org.example.productservice.product.dto.in.AddProductRequestDto;
import org.example.productservice.product.dto.in.DeleteProductRequestDto;
import org.example.productservice.product.dto.in.UpdateProductRequestDto;

public interface ProductService {

	void addProduct(AddProductRequestDto addProductRequestDto);
	void updateProduct(UpdateProductRequestDto updateProductRequestDto);
	void deleteProduct(DeleteProductRequestDto deleteProductRequestDto);
	// GetProductDetailResponseDto getProductDetail(GetProductDetailRequestDto getProductDetailRequestDto);
}
