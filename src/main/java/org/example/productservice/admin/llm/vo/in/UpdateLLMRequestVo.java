package org.example.productservice.admin.llm.vo.in;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateLLMRequestVo {

	private Long llmId;
	private String name;

	@Builder
	public UpdateLLMRequestVo(Long llmId, String name) {
		this.llmId = llmId;
		this.name = name;
	}
}
