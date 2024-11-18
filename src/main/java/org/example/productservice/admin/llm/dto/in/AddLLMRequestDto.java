package org.example.productservice.admin.llm.dto.in;

import org.example.productservice.admin.llm.vo.in.AddLLMRequestVo;
import org.example.productservice.common.llm.domain.LLM;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddLLMRequestDto {

	private String llmName;
	private String llmType;

	public static AddLLMRequestDto toDto(AddLLMRequestVo addLLMRequestVo) {
		return AddLLMRequestDto.builder()
				.llmName(addLLMRequestVo.getLlmName())
				.llmType(addLLMRequestVo.getLlmType())
				.build();
	}

	public LLM createEntity() {
		return LLM.builder()
				.llmName(llmName)
				.llmType(llmType)
				.deleted(false)
				.build();
	}

	public LLM updateEntity(Long llmId) {
		return LLM.builder()
			.llmId(llmId)
			.llmName(llmName)
			.llmType(llmType)
			.deleted(false)
			.build();
	}
}
