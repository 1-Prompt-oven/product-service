package org.example.productservice.seller.product.application;

import java.util.List;

import org.example.productservice.seller.product.dto.in.AddProductContentRequestDto;
import org.example.productservice.seller.product.dto.in.UpdateProductContentRequestDto;
import org.example.productservice.seller.product.dto.out.GetProductContentResponseDto;

public interface SellerProductContentService {

	void addProductContent(AddProductContentRequestDto addProductContentRequestDto);

	void updateProductContent(UpdateProductContentRequestDto updateProductContentRequestDto);

	void deleteProductContent(String productContentUuid);

	List<GetProductContentResponseDto> getProductContentList(String productUuid);
}
