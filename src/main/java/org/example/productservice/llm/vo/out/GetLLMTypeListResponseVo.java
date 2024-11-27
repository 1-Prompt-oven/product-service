package org.example.productservice.llm.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAllLLMResponseVo {

	private Long llmId;
	private String name;

	@Builder
	public GetAllLLMResponseVo(Long llmId, String name) {
		this.llmId = llmId;
		this.name = name;
	}
}
