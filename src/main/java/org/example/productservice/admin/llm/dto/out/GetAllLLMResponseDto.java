package org.example.productservice.admin.llm.dto.out;

import org.example.productservice.admin.llm.vo.out.GetAllLLMResponseVo;
import org.example.productservice.common.llm.domain.LLM;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllLLMResponseDto {

	private Long llmId;
	private String llmName;
	private Long llmTypeId;
	private String llmTypeName;

	public static GetAllLLMResponseDto toDto(LLM llm) {
		return GetAllLLMResponseDto.builder()
				.llmId(llm.getLlmId())
				.llmName(llm.getLlmName())
				.llmTypeId(llm.getLlmTypeId())
				.llmTypeName(llm.getLlmTypeName())
				.build();
	}

	public GetAllLLMResponseVo toVo() {
		return GetAllLLMResponseVo.builder()
			.llmId(llmId)
			.llmName(llmName)
			.llmTypeId(llmTypeId)
			.llmTypeName(llmTypeName)
			.build();
	}
}
