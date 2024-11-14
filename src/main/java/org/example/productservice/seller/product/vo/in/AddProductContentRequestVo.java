package org.example.productservice.seller.product.vo.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class AddProductContentRequestVo {

	private String productUuid;
	private String contentUrl;
	private int order;
	private String sampleValue;
}
