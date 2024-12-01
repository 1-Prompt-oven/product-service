package org.example.productservice.productlike.dto.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetProductLikeListRequestDto {

	private String memberUuid;
	private String sortOption;
	private int pageSize;
	private Long cursorId;
}
