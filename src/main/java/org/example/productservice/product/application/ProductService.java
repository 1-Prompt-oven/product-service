package org.example.productservice.product.application;

import org.example.productservice.product.dto.in.AddProductRequestDto;

public interface ProductService {

	void addProduct(AddProductRequestDto addProductRequestDto);
	// void updateProduct(UpdateProductRequestDto updateProductRequestDto);
	// void deleteProduct(DeleteProductRequestDto deleteProductRequestDto);
}
