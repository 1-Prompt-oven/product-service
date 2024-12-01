package org.example.productservice.productlike.infrastructure;

import java.util.List;
import java.util.Optional;

import org.example.productservice.productlike.domain.ProductLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductLikeRepository extends JpaRepository<ProductLike, Long> {

	Optional<ProductLike> findByMemberUuidAndProductUuid(String memberUuid, String productUuid);

	@Query("SELECT pl FROM ProductLike pl WHERE pl.memberUuid = :memberUuid " +
		"AND pl.liked = true " +
		"AND (:cursorId IS NULL OR pl.productLikeId < :cursorId) " +
		"ORDER BY pl.productLikeId DESC " +
		"LIMIT :pageSize")
	List<ProductLike> findLikedProductsByMemberUuidWithCursorDesc(
		@Param("memberUuid") String memberUuid,
		@Param("cursorId") Long cursorId,
		@Param("pageSize") int pageSize
	);

	@Query("SELECT pl FROM ProductLike pl WHERE pl.memberUuid = :memberUuid " +
		"AND pl.liked = true " +
		"AND (:cursorId IS NULL OR pl.productLikeId > :cursorId) " +
		"ORDER BY pl.productLikeId ASC " +
		"LIMIT :pageSize")
	List<ProductLike> findLikedProductsByMemberUuidWithCursorAsc(
		@Param("memberUuid") String memberUuid,
		@Param("cursorId") Long cursorId,
		@Param("pageSize") int pageSize
	);
}
