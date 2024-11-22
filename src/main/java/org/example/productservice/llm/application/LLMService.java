package org.example.productservice.llm.application;

import java.util.List;

import org.example.productservice.llm.dto.in.AddLLMRequestDto;
import org.example.productservice.llm.dto.in.DeleteLLMRequestDto;
import org.example.productservice.llm.dto.out.GetLLMListByTypeResponseDto;
import org.example.productservice.llm.dto.out.GetLLMNameByLLMIdResponseDto;

public interface LLMService {

	void createLLM(AddLLMRequestDto addLLMRequestDto);

	void updateLLM(Long llmId, AddLLMRequestDto addLLMRequestDto);

	void deleteLLM(DeleteLLMRequestDto deleteLLMRequestDto);

	List<GetLLMListByTypeResponseDto> getLLMListByType(String llmType);

	GetLLMNameByLLMIdResponseDto getLLMNameByLLMId(Long llmId);
}
