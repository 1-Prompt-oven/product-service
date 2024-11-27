package org.example.productservice.productlike.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductLike {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productLikeId;

	@Column(nullable = false)
	private String productUuid;

	@Column(nullable = false)
	private String memberUuid;

	@Column(nullable = false)
	private boolean liked;
}
