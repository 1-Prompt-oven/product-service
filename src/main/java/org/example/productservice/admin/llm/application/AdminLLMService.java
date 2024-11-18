package org.example.productservice.admin.llm.application;

import java.util.List;

import org.example.productservice.admin.llm.dto.in.AddLLMRequestDto;
import org.example.productservice.admin.llm.dto.in.DeleteLLMRequestDto;
import org.example.productservice.admin.llm.dto.out.GetLLMListByTypeResponseDto;

public interface AdminLLMService {

	void createLLM(AddLLMRequestDto addLLMRequestDto);

	void updateLLM(Long llmId, AddLLMRequestDto addLLMRequestDto);

	void deleteLLM(DeleteLLMRequestDto deleteLLMRequestDto);

	List<GetLLMListByTypeResponseDto> getLLMListByType(String llmType);
}
