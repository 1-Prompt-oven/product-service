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
	private Long llmTypeId;
	private String llmTypeName;

	public static AddLLMRequestDto toDto(AddLLMRequestVo addLLMRequestVo) {
		return AddLLMRequestDto.builder()
				.llmName(addLLMRequestVo.getLlmName())
				.llmTypeId(addLLMRequestVo.getLlmTypeId())
				.llmTypeName(addLLMRequestVo.getLlmTypeName())
				.build();
	}

	public LLM toEntity() {
		return LLM.builder()
				.llmName(llmName)
				.llmTypeId(llmTypeId)
				.llmTypeName(llmTypeName)
				.deleted(false)
				.build();
	}
}
