package org.example.productservice.admin.llm.dto.in;

import org.example.productservice.admin.llm.vo.in.AddLLMVersionRequestVo;
import org.example.productservice.common.llm.domain.LLMVersion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddLLMVersionRequestDto {

	private String llmVersionName;
	private Long llmId;

	public static AddLLMVersionRequestDto toDto(AddLLMVersionRequestVo addLLMVersionRequestVo) {
		return AddLLMVersionRequestDto.builder()
				.llmVersionName(addLLMVersionRequestVo.getLlmVersionName())
				.build();
	}

	public LLMVersion createEntity() {
		return LLMVersion.builder()
				.llmVersionName(llmVersionName)
				.llmId(llmId)
				.deleted(false)
				.build();
	}

	public LLMVersion updateEntity(Long llmVersionId) {
		return LLMVersion.builder()
				.llmVersionId(llmVersionId)
				.llmVersionName(llmVersionName)
				.llmId(llmId)
				.deleted(false)
				.build();
	}
}
