package org.example.productservice.product.infrastructure;

import java.util.Optional;

import org.example.productservice.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SellerProductRepository extends JpaRepository<Product, Long> {
	@Query("SELECT p FROM Product p WHERE p.productUuid = :productUuid")
	Optional<Product> findByProductUuid(String productUuid);

	boolean existsByProductName(String productName);

	boolean existsByProductUuid(String productUuid);
}
