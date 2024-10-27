package org.example.productservice.admin.llm.vo.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class DeleteLLMRequestVo {

	private Long llmId;

	@Builder
	public DeleteLLMRequestVo(Long llmId) {
		this.llmId = llmId;
	}
}
