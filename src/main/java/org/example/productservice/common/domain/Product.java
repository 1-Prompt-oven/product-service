package org.example.productservice.common.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	@Column(nullable = false, length = 50)
	private String productUuid;

	@Column(nullable = false, length = 50)
	private String sellerUuid;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(nullable = false)
	private int price;

	@Column(nullable = false, length = 500)
	private String prompt;

	@Column(nullable = false, length = 100)
	private String description;
}
