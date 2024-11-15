package org.example.productservice.admin.llm.application;

import java.util.List;

import org.example.productservice.admin.llm.dto.in.AddLLMRequestDto;
import org.example.productservice.admin.llm.dto.in.DeleteLLMRequestDto;
import org.example.productservice.admin.llm.dto.in.UpdateLLMRequestDto;
import org.example.productservice.admin.llm.dto.out.GetLLMListByTypeResponseDto;

public interface AdminLLMService {

	void createLLM(AddLLMRequestDto createLLMRequestDto);

	void updateLLM(UpdateLLMRequestDto updateLLMRequestDto);

	void deleteLLM(DeleteLLMRequestDto deleteLLMRequestDto);

	List<GetLLMListByTypeResponseDto> getLLMListByType(Long llmTypeId);
}
