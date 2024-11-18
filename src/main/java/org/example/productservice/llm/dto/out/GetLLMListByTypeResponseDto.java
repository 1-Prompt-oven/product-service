package org.example.productservice.llm.dto.out;

import org.example.productservice.llm.vo.out.GetLLMListByTypeResponseVo;
import org.example.productservice.llm.domain.LLM;

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
	private String llmType;

	public static GetLLMListByTypeResponseDto toDto(LLM llm) {
		return GetLLMListByTypeResponseDto.builder()
				.llmId(llm.getLlmId())
				.llmName(llm.getLlmName())
				.llmType(llm.getLlmType())
				.build();
	}

	public GetLLMListByTypeResponseVo toVo() {
		return GetLLMListByTypeResponseVo.builder()
			.llmId(llmId)
			.llmName(llmName)
			.llmType(llmType)
			.build();
	}
}
