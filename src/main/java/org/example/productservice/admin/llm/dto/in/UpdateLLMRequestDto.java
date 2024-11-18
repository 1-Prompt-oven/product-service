package org.example.productservice.admin.llm.dto.in;

import org.example.productservice.admin.llm.vo.in.UpdateLLMRequestVo;
import org.example.productservice.common.llm.domain.LLM;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateLLMRequestDto {

	private Long llmId;
	private String name;
	private Long llmTypeId;
	private String llmTypeName;

	public static UpdateLLMRequestDto toDto(UpdateLLMRequestVo updateLLMRequestVo) {
		return UpdateLLMRequestDto.builder()
				.llmId(updateLLMRequestVo.getLlmId())
				.name(updateLLMRequestVo.getName())
				.llmTypeId(updateLLMRequestVo.getLlmTypeId())
				.llmTypeName(updateLLMRequestVo.getLlmTypeName())
				.build();
	}

	public LLM toEntity() {
		return LLM.builder()
				.llmId(llmId)
				.llmName(name)
				.llmTypeId(llmTypeId)
				.llmTypeName(llmTypeName)
				.deleted(false)
				.build();
	}
}
