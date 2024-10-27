package org.example.productservice.admin.llm.dto.in;

import org.example.productservice.admin.llm.vo.in.DeleteLLMRequestVo;
import org.example.productservice.common.domain.LLM;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class DeleteLLMRequestDto {

	private Long llmId;

	@Builder
	public DeleteLLMRequestDto(Long llmId) {
		this.llmId = llmId;
	}

	public static DeleteLLMRequestDto toDto(DeleteLLMRequestVo deleteLLMRequestVo) {
		return DeleteLLMRequestDto.builder()
				.llmId(deleteLLMRequestVo.getLlmId())
				.build();
	}

	public LLM toEntity(LLM llm) {
		return LLM.builder()
				.llmId(llmId)
			.name(llm.getName())
			.deleted(true)
			.build();
	}
}
