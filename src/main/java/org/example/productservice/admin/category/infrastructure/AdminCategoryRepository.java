package org.example.productservice.admin.category.infrastructure;

import java.util.List;
import java.util.Optional;

import org.example.productservice.common.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminCategoryRepository extends JpaRepository<Category, Long> {

	@Query("SELECT c FROM Category c WHERE c.categoryUuid = :categoryUuid")
	Optional<Category> findByCategoryUuid(String categoryUuid);

	List<Category> findByParentCategoryUuid(String parentCategoryUuid);

	List<Category> findByParentCategoryUuidIsNull();

	Boolean existsByCategoryName(String categoryName);

	Optional<Category> findByCategoryName(String rootCategoryName);
}
