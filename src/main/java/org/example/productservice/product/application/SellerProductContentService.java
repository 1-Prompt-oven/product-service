package org.example.productservice.product.application;

import java.util.List;

import org.example.productservice.product.dto.in.AddProductContentRequestDto;
import org.example.productservice.product.dto.in.UpdateProductContentRequestDto;
import org.example.productservice.product.dto.out.GetProductContentResponseDto;

public interface SellerProductContentService {

	void addProductContent(AddProductContentRequestDto addProductContentRequestDto);

	void updateProductContent(UpdateProductContentRequestDto updateProductContentRequestDto);

	void deleteProductContent(String productContentUuid);

	List<GetProductContentResponseDto> getProductContentList(String productUuid);
}
