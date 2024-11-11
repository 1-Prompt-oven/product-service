package org.example.productservice.seller.product.infrastructure;

import java.util.Optional;

import org.example.productservice.common.product.domain.ProductContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerProductContentRepository extends JpaRepository<ProductContent, Long> {
	Optional<ProductContent> findByProductUuid(String productUuid);
}
