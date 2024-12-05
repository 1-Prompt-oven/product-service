package org.example.productservice.product.application;

import java.util.List;

import org.example.productservice.product.dto.in.AddProductRequestDto;
import org.example.productservice.product.dto.in.GetProductListRequestDto;
import org.example.productservice.product.dto.in.UpdateProductRequestDto;
import org.example.productservice.product.dto.message.GetProductListResponseDto;
import org.example.productservice.product.dto.out.GetProductDetailResponseDto;
import org.example.productservice.product.dto.out.GetSellerUuidByProductUuidResponseDto;
import org.example.productservice.product.dto.out.GetTemporaryProductListResponseDto;
import org.example.productservice.product.dto.out.TemporaryAddProductResponseDto;

public interface ProductService {

	void addProduct(AddProductRequestDto addProductRequestDto);
	void updateProduct(UpdateProductRequestDto updateProductRequestDto);
	void deleteProduct(String productUuid);
	GetProductDetailResponseDto getProductDetail(String productUuid);
	GetSellerUuidByProductUuidResponseDto getSellerUuidByProductUuid(String productUuid);
	GetProductListResponseDto searchProducts(GetProductListRequestDto getProductListRequestDto);

	TemporaryAddProductResponseDto temporaryAddProduct(AddProductRequestDto addProductRequestDto);
	List<GetTemporaryProductListResponseDto> getTemporaryProductList(String memberUuid);

	void updateAvgRating(String productUuid, Double avgRating);
}
