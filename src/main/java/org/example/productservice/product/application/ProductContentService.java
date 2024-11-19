package org.example.productservice.product.application;

import org.example.productservice.product.dto.in.AddProductContentRequestDto;
import org.example.productservice.product.dto.in.UpdateProductContentRequestDto;

public interface ProductContentService {

	void addProductContent(AddProductContentRequestDto addProductContentRequestDto);

	void updateProductContent(UpdateProductContentRequestDto updateProductContentRequestDto);

	void deleteProductContent(String productContentUuid);

}
