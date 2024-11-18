package org.example.productservice.admin.llm.application;

import java.util.List;

import org.example.productservice.admin.llm.dto.in.AddLLMTypeRequestDto;
import org.example.productservice.admin.llm.dto.out.GetLLMTypeListResponseDto;

public interface AdminLLMTypeService {

	void addLLMType(AddLLMTypeRequestDto addLLMTypeRequestDto);

	void updateLLMType(Long llmTypeId, AddLLMTypeRequestDto addLLMTypeRequestDto);

	void deleteLLMType(Long llmTypeId);

	List<GetLLMTypeListResponseDto> getLLMTypeList();
}
