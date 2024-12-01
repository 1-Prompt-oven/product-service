package org.example.productservice.product.application;

import java.util.List;

import org.example.productservice.product.dto.in.AddProductRequestDto;
import org.example.productservice.product.dto.in.GetProductListRequestDto;
import org.example.productservice.product.dto.in.UpdateProductRequestDto;
import org.example.productservice.product.dto.message.GetProductListResponseDto;
import org.example.productservice.product.dto.out.GetProductDetailResponseDto;
import org.example.productservice.product.dto.out.GetSellerUuidByProductUuidResponseDto;
import org.example.productservice.product.dto.out.GetTemporaryProductListResponseDto;

public interface ProductService {

	void addProduct(AddProductRequestDto addProductRequestDto);
	void updateProduct(UpdateProductRequestDto updateProductRequestDto);
	void deleteProduct(String productUuid);
	GetProductDetailResponseDto getProductDetail(String productUuid);
	GetSellerUuidByProductUuidResponseDto getSellerUuidByProductUuid(String productUuid);
	GetProductListResponseDto searchProducts(GetProductListRequestDto getProductListRequestDto);

	void temporaryAddProduct(AddProductRequestDto addProductRequestDto);
	List<GetTemporaryProductListResponseDto> getTemporaryProductList(String memberUuid);
}
