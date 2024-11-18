package org.example.productservice.product.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Getter
public class ProductContent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productContentId;

	@Column(nullable = false)
	private String productContentUuid;

	@Column(nullable = false)
	private String productUuid;

	@Column(nullable = false)
	private String contentUrl;

	@Column(nullable = false)
	private int contentOrder;

	@Column(nullable = false)
	private String sampleValue;

	@Column(nullable = false)
	private boolean deleted;
}
