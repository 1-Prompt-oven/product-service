package org.example.productservice.seller.product.application;

import org.example.productservice.seller.product.dto.in.AddProductRequestDto;
import org.example.productservice.seller.product.dto.in.DeleteProductRequestDto;
import org.example.productservice.seller.product.dto.in.GetProductDetailRequestDto;
import org.example.productservice.seller.product.dto.out.GetProductDetailResponseDto;

public interface SellerProductService {

	void addProduct(AddProductRequestDto addProductRequestDto);
	void updateProduct(Long productUuid, AddProductRequestDto addProductRequestDto);
	void deleteProduct(DeleteProductRequestDto deleteProductRequestDto);
	GetProductDetailResponseDto getProductDetail(GetProductDetailRequestDto getProductDetailRequestDto);
}
