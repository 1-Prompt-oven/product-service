package org.example.productservice.category.infrastructure;

import java.util.List;

import org.example.productservice.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query("SELECT c FROM Category c WHERE c.deleted = false " +
		"AND (:parentCategoryUuid IS NULL OR c.parentCategoryUuid = :parentCategoryUuid)")
	List<Category> findByParentCategoryUuid(String parentCategoryUuid);


}
