package org.example.productservice.seller.product.presentation;

import org.example.productservice.seller.product.dto.in.CreateProductRequestDto;

public interface SellerProductService {

	void createProduct(CreateProductRequestDto createProductRequestDto);
}
