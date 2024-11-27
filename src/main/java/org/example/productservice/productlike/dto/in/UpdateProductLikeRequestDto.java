package org.example.productservice.productlike.dto.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class UpdateProductLikeRequestDto {

	private String memberUuid;
	private String productUuid;
}
