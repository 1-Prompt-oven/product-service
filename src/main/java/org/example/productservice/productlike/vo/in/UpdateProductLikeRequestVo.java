package org.example.productservice.productlike.vo.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class UpdateProductLikeRequestVo {

	private String memberUuid;

	private String productUuid;
}
