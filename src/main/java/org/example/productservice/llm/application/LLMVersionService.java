package org.example.productservice.llm.application;

import java.util.List;

import org.example.productservice.llm.dto.in.GetLLMVersionListRequestDto;

public interface LLMVersionService {

	List<GetLLMVersionListRequestDto> getLLMVersionListByLLMId(Long llmId);
}
