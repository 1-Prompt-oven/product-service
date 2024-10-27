package org.example.productservice.admin.llm.dto.out;

import org.example.productservice.admin.llm.vo.out.GetAllLLMResponseVo;
import org.example.productservice.common.domain.LLM;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAllLLMResponseDto {

	private Long llmId;
	private String name;

	@Builder
	public GetAllLLMResponseDto(Long llmId, String name) {
		this.llmId = llmId;
		this.name = name;
	}

	public static GetAllLLMResponseDto toDto(LLM llm) {
		return GetAllLLMResponseDto.builder()
				.llmId(llm.getLlmId())
				.name(llm.getName())
				.build();
	}

	public GetAllLLMResponseVo toVo() {
		return GetAllLLMResponseVo.builder()
			.llmId(llmId)
			.name(name)
			.build();
	}
}
