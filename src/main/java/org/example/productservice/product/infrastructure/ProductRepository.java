package org.example.productservice.product.infrastructure;

import java.util.Optional;

import org.example.productservice.product.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	Optional<Product> findByProductUuid(String productUuid);
}
