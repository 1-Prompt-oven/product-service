package org.example.productservice.llm.application;

import java.util.List;

import org.example.productservice.llm.dto.in.GetLLMVersionListRequestDto;
import org.example.productservice.llm.infrastructure.LLMVersionRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class LLMVersionServiceImpl implements LLMVersionService {

	private final LLMVersionRepository llmVersionRepository;

	@Override
	public List<GetLLMVersionListRequestDto> getLLMVersionListByLLMId(Long llmId) {

		return llmVersionRepository.findByLlmIdAndDeletedFalse(llmId)
			.stream()
			.map(llmVersion -> GetLLMVersionListRequestDto.builder()
				.llmVersionId(llmVersion.getLlmVersionId())
				.llmVersionName(llmVersion.getLlmVersionName())
				.llmId(llmVersion.getLlmId())
				.build()
			)
			.toList();
	}

}
