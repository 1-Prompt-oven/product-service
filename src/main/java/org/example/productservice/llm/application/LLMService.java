package org.example.productservice.llm.application;

import java.util.List;

import org.example.productservice.llm.dto.out.GetLLMListByTypeResponseDto;
import org.example.productservice.llm.dto.out.GetLLMNameByLLMIdResponseDto;
import org.example.productservice.llm.dto.out.GetLLMNameByProductUuidResponseDto;

public interface LLMService {

	List<GetLLMListByTypeResponseDto> getLLMListByType(String llmType);

	GetLLMNameByLLMIdResponseDto getLLMNameByLLMId(Long llmId);

	GetLLMNameByProductUuidResponseDto getLLMNameByProductUuid(String productUuid);
}
