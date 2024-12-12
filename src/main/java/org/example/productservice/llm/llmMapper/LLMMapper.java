package org.example.productservice.llm.llmMapper;

import org.example.productservice.llm.domain.LLM;
import org.example.productservice.llm.dto.out.GetLLMNameByLLMIdResponseDto;
import org.example.productservice.llm.dto.out.GetLLMNameByProductUuidResponseDto;
import org.example.productservice.llm.vo.out.GetLLMNameByLLMIdResponseVo;
import org.example.productservice.llm.vo.out.GetLLMNameByProductUuidResponseVo;
import org.springframework.stereotype.Component;

@Component
public class LLMMapper {

	public GetLLMNameByLLMIdResponseDto toDto(LLM llm) {

		return GetLLMNameByLLMIdResponseDto.builder()
			.llmName(llm.getLlmName())
			.build();
	}

	public GetLLMNameByLLMIdResponseVo toVo(GetLLMNameByLLMIdResponseDto llmNameByLLMId) {

		return GetLLMNameByLLMIdResponseVo.builder()
			.llmName(llmNameByLLMId.getLlmName())
			.build();
	}

	public GetLLMNameByProductUuidResponseDto toDto(String llmName) {

		return GetLLMNameByProductUuidResponseDto.builder()
			.llmName(llmName)
			.build();
	}

	public GetLLMNameByProductUuidResponseVo toVo(GetLLMNameByProductUuidResponseDto getLLMNameByProductUuidResponseDto) {

		return GetLLMNameByProductUuidResponseVo.builder()
			.llmName(getLLMNameByProductUuidResponseDto.getLlmName())
			.build();
	}
}
