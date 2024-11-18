package org.example.productservice.product.application;

import org.example.productservice.product.dto.in.AddProductRequestDto;
import org.example.productservice.product.dto.in.DeleteProductRequestDto;
import org.example.productservice.product.dto.in.GetProductDetailRequestDto;
import org.example.productservice.product.dto.in.UpdateProductRequestDto;
import org.example.productservice.product.dto.out.GetProductDetailResponseDto;

public interface SellerProductService {

	void addProduct(AddProductRequestDto addProductRequestDto);
	void updateProduct(UpdateProductRequestDto updateProductRequestDto);
	void deleteProduct(DeleteProductRequestDto deleteProductRequestDto);
	GetProductDetailResponseDto getProductDetail(GetProductDetailRequestDto getProductDetailRequestDto);
}
