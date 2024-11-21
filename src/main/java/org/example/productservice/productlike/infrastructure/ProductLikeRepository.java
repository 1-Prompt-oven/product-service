package org.example.productservice.productlike.infrastructure;

import java.util.Optional;

import org.example.productservice.productlike.domain.ProductLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLikeRepository extends JpaRepository<ProductLike, Long> {

	Optional<ProductLike> findByMemberUuidAndProductUuid(String memberUuid, String productUuid);
}
