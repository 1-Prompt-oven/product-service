package org.example.productservice.common.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Builder;
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
	private String sellerName;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(nullable = false)
	private int price;

	@Column(nullable = false, length = 500)
	private String prompt;

	@Column(nullable = false, length = 100)
	private String description;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_policy_id")
	private ProductPolicy productPolicy;

	@Builder
	public Product(Long productId, String productUuid, String sellerUuid, String name, int price, String prompt,
		String description, String sellerName) {
		this.productId = productId;
		this.productUuid = productUuid;
		this.sellerUuid = sellerUuid;
		this.name = name;
		this.price = price;
		this.prompt = prompt;
		this.description = description;
		this.sellerName = sellerName;
	}

	@Builder
	public Product(String productUuid, String sellerUuid, String name, int price, String prompt,
		String description, String sellerName) {
		this.productUuid = productUuid;
		this.sellerUuid = sellerUuid;
		this.name = name;
		this.price = price;
		this.prompt = prompt;
		this.description = description;
		this.sellerName = sellerName;
	}
}
