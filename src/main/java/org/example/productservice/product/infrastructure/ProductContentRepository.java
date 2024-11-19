package org.example.productservice.product.infrastructure;

import java.util.List;
import java.util.Optional;

import org.example.productservice.product.domain.ProductContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductContentRepository extends JpaRepository<ProductContent, Long> {
	Optional<ProductContent> findByProductUuid(String productUuid);

	Optional<ProductContent> findByProductContentUuid(String productContentUuid);

	List<ProductContent> findContentListByProductUuid(String productUuid);
}
