package org.example.productservice.seller.product.dto.in;

import org.example.productservice.common.domain.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CreateProductRequestDto {




	private Product product;

	private float discountRate;

	private boolean enabled;

	private boolean premium;

	private Long thumbnailId;

	private boolean approved;

	private Long llmId;
}
