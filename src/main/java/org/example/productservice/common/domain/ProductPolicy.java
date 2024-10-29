package org.example.productservice.common.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Builder;
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

	@Builder
	public ProductPolicy(Long productPolicyId, Product product, float discountRate, boolean enabled, boolean premium,
		String thumbnailSrc, boolean deleted, boolean approved, Long llmId) {
		this.productPolicyId = productPolicyId;
		this.product = product;
		this.discountRate = discountRate;
		this.enabled = enabled;
		this.premium = premium;
		this.thumbnailSrc = thumbnailSrc;
		this.deleted = deleted;
		this.approved = approved;
		this.llmId = llmId;
	}

	@Builder
	public ProductPolicy(Product product, float discountRate, boolean enabled, boolean premium, String thumbnailSrc,
		boolean deleted, boolean approved, Long llmId) {
		this.product = product;
		this.discountRate = discountRate;
		this.enabled = enabled;
		this.premium = premium;
		this.thumbnailSrc = thumbnailSrc;
		this.deleted = deleted;
		this.approved = approved;
		this.llmId = llmId;
	}
}
