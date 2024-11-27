package org.example.productservice.admin.llm.vo.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddLLMRequestVo {

	private String name;

	@Builder
	public AddLLMRequestVo(String name) {
		this.name = name;
	}
}
