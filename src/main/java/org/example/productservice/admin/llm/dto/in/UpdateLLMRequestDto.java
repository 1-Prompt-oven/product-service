package org.example.productservice.admin.llm.dto.in;

import org.example.productservice.admin.llm.vo.in.UpdateLLMRequestVo;
import org.example.productservice.common.domain.LLM;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateLLMRequestDto {

	private Long llmId;
	private String name;

	@Builder
	public UpdateLLMRequestDto(Long llmId, String name) {
		this.llmId = llmId;
		this.name = name;
	}

	public static UpdateLLMRequestDto toDto(UpdateLLMRequestVo updateLLMRequestVo) {
		return UpdateLLMRequestDto.builder()
				.llmId(updateLLMRequestVo.getLlmId())
				.name(updateLLMRequestVo.getName())
				.build();
	}

	public LLM toEntity() {
		return LLM.builder()
				.llmId(llmId)
				.name(name)
				.deleted(false)
				.build();
	}
}
