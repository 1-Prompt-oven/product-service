package org.example.productservice.admin.llm.application;

import java.util.List;

import org.example.productservice.admin.llm.dto.in.AddLLMVersionRequestDto;
import org.example.productservice.admin.llm.dto.in.GetLLMVersionListRequestDto;
import org.example.productservice.admin.llm.infrastructure.AdminLLMVersionRepository;
import org.example.productservice.common.llm.domain.LLMVersion;
import org.example.productservice.global.common.response.BaseResponseStatus;
import org.example.productservice.global.error.BaseException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminLLMVersionServiceImpl implements AdminLLMVersionService {

	private final AdminLLMVersionRepository adminLlmVersionRepository;

	@Override
	public void addLLMVersion(AddLLMVersionRequestDto addLLMVersionRequestDto) {

		if (adminLlmVersionRepository.existsByLlmVersionName(addLLMVersionRequestDto.getLlmVersionName())) {
			throw new BaseException(BaseResponseStatus.DUPLICATED_DATA);
		}

		adminLlmVersionRepository.save(addLLMVersionRequestDto.createEntity());
	}

	@Override
	public void updateLLMVersion(Long llmVersionId, AddLLMVersionRequestDto addLLMVersionRequestDto) {

		adminLlmVersionRepository.save(addLLMVersionRequestDto.updateEntity(llmVersionId));
	}

	@Override
	public void deleteLLMVersion(Long llmVersionId) {

		LLMVersion llmVersion = adminLlmVersionRepository.findById(llmVersionId)
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		adminLlmVersionRepository.save(
			LLMVersion.builder()
				.llmVersionId(llmVersion.getLlmVersionId())
				.llmVersionName(llmVersion.getLlmVersionName())
				.llmId(llmVersion.getLlmId())
				.deleted(true)
				.build()
		);
	}

	@Override
	public List<GetLLMVersionListRequestDto> getLLMVersionListByLLMId(Long llmId) {

		return adminLlmVersionRepository.findByLlmIdAndDeletedFalse(llmId)
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
