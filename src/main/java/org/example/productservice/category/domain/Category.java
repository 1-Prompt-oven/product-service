package org.example.productservice.category.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Long id;

	@Column(nullable = false, length = 100)
	private String categoryName;

	@Column(nullable = false, length = 100, unique = true)
	private String categoryUuid;

	@Column(name = "parent_category_uuid")
	private String parentCategoryUuid;

	@Column(nullable = false)
	private int depth;

	@Column(nullable = false)
	private boolean deleted;

}