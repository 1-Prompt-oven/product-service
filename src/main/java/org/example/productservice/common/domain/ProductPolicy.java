package org.example.productservice.common.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ProductPolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productPolicyId;

	@OneToOne(mappedBy = "productPolicy")
	private Product product;

	@Column(nullable = false)
	private float discountRate;

	@Column(nullable = false)
	private boolean enabled;

	@Column(nullable = false)
	private boolean premium;

	private String thumbnailSrc;

	@Column(nullable = false)
	private boolean deleted;

	@Column(nullable = false)
	private boolean approved;

	@Column(nullable = false)
	private Long llmId;
}
