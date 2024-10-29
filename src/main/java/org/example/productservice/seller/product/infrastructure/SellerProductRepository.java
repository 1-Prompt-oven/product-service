package org.example.productservice.seller.product.infrastructure;

import java.util.Optional;

import org.example.productservice.common.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SellerProductRepository extends JpaRepository<Product, Long> {
	@Query("SELECT p FROM Product p WHERE p.productUuid = :productUuid")
	Optional<Product> findByUuid(String productUuid);
}
