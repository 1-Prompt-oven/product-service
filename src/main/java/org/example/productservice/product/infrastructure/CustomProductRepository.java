package org.example.productservice.product.infrastructure;

import java.util.List;

import org.example.productservice.product.domain.Product;
import org.example.productservice.product.dto.in.GetProductListRequestDto;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomProductRepository {

	List<Product> findProductListWithCursor(GetProductListRequestDto productListRequestDto, int pageSize);
}
