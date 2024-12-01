package org.example.productservice.product.dto.out;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetTemporaryProductListResponseDto {

	private String productUuid;
	private String productName;
	private LocalDateTime createdAt;
}
