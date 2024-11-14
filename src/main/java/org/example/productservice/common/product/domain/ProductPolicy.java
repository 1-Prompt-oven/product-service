package org.example.productservice.common.product.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@AllArgsConstructor
@Builder
public class ProductPolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productPolicyId;

	@Column(nullable = false)
	private String productPolicyUuid;

	@Column(nullable = false)
	private String productUuid;

	@Column(nullable = false)
	private float discountRate;

	@Column(nullable = false)
	private boolean enabled;

	private String thumbnailSrc;

	@Column(nullable = false)
	private boolean deleted;

	@Column(nullable = false)
	private boolean approved;

	@Column(nullable = false)
	private Long llmId;

	@Column(nullable = false)
	private String llmName;

}
