package org.example.productservice.llm.application;

import java.util.List;

import org.example.productservice.llm.dto.in.AddLLMVersionRequestDto;
import org.example.productservice.llm.dto.in.GetLLMVersionListRequestDto;

public interface LLMVersionService {

	void addLLMVersion(AddLLMVersionRequestDto addLLMVersionRequestDto);

	void updateLLMVersion(Long llmVersionId, AddLLMVersionRequestDto addLLMVersionRequestDto);

	void deleteLLMVersion(Long llmVersionId);

	List<GetLLMVersionListRequestDto> getLLMVersionListByLLMId(Long llmId);
}
