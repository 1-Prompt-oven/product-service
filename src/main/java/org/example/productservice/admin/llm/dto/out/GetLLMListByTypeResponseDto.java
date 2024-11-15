package org.example.productservice.admin.llm.dto.out;

import org.example.productservice.admin.llm.vo.out.GetLLMListByTypeResponseVo;
import org.example.productservice.common.llm.domain.LLM;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetLLMListByTypeResponseDto {

	private Long llmId;
	private String llmName;
	private Long llmTypeId;
	private String llmTypeName;

	public static GetLLMListByTypeResponseDto toDto(LLM llm) {
		return GetLLMListByTypeResponseDto.builder()
				.llmId(llm.getLlmId())
				.llmName(llm.getLlmName())
				.llmTypeId(llm.getLlmTypeId())
				.llmTypeName(llm.getLlmTypeName())
				.build();
	}

	public GetLLMListByTypeResponseVo toVo() {
		return GetLLMListByTypeResponseVo.builder()
			.llmId(llmId)
			.llmName(llmName)
			.llmTypeId(llmTypeId)
			.llmTypeName(llmTypeName)
			.build();
	}
}
