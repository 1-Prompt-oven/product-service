package org.example.productservice.product.domain;

import org.hibernate.annotations.DynamicUpdate;

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
@Builder
@AllArgsConstructor
@DynamicUpdate
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	@Column(nullable = false, length = 50)
	private String productUuid;

	@Column(nullable = false, length = 50)
	private String sellerUuid;

	@Column(nullable = false, length = 50)
	private String productName;

	// 통화체계에 따라 유연하게 하게끔 Double. 금액은 무조건 double.
	// 정산관련할때 수익률 같은거 하게끔하면 반올림 관련해서도 애매해지는 부분이 있으니 double 쓰는게 좋음.
	@Column(nullable = false)
	private double price;

	// 암호화 고려하더라도 길이를 더 길게 쓰자.
	@Column(nullable = false, length = 3000)
	private String prompt;

	@Column(nullable = false, length = 1000)
	private String description;

	@Column(nullable = false)
	private Long llmId;

	@Column(nullable = false)
	private String topCategoryUuid;

	@Column(nullable = false)
	private String subCategoryUuid;

	@Column(nullable = false)
	private boolean deleted;
}
