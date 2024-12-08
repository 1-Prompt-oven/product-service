package org.example.productservice.product.infrastructure;

import java.util.List;

import org.example.productservice.product.domain.Product;
import org.example.productservice.product.dto.in.GetProductListRequestDto;
import org.example.productservice.product.dto.in.GetSellersProductListRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomProductRepository {

	List<Product> findProductListWithCursor(GetProductListRequestDto productListRequestDto, int pageSize);
	Page<Product> findSellersProductList(GetSellersProductListRequestDto dto, Pageable pageable);
}
