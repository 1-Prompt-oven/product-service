package org.example.productservice.product.infrastructure;

import java.util.Optional;

import org.example.productservice.product.domain.ProductPolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerProductPolicyRepository extends JpaRepository<ProductPolicy, Long> {

	Optional<ProductPolicy> findByProductUuid(String productUuid);

	boolean existsByProductUuid(String productUuid);
}
