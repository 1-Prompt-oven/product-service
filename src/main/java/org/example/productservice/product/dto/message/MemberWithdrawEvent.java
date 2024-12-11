package org.example.productservice.product.dto.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class MemberWithdrawEvent {

	private final String memberUUID;
}
