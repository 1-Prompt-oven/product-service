package org.example.productservice.admin.llm.application;

import java.util.List;

import org.example.productservice.admin.llm.dto.in.AddLLMVersionRequestDto;
import org.example.productservice.admin.llm.dto.in.GetLLMVersionListRequestDto;

public interface AdminLLMVersionService {

	void addLLMVersion(AddLLMVersionRequestDto addLLMVersionRequestDto);

	void updateLLMVersion(Long llmVersionId, AddLLMVersionRequestDto addLLMVersionRequestDto);

	void deleteLLMVersion(Long llmVersionId);

	List<GetLLMVersionListRequestDto> getLLMVersionListByLLMId(Long llmId);
}
