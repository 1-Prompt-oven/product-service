package org.example.productservice.admin.llm.application;

import java.util.List;

import org.example.productservice.admin.llm.dto.in.AddLLMRequestDto;
import org.example.productservice.admin.llm.dto.in.DeleteLLMRequestDto;
import org.example.productservice.admin.llm.dto.in.UpdateLLMRequestDto;
import org.example.productservice.admin.llm.dto.out.GetLLMListByTypeResponseDto;
import org.example.productservice.admin.llm.infrastructure.AdminLLMRepository;
import org.example.productservice.common.llm.domain.LLM;
import org.example.productservice.global.common.response.BaseResponseStatus;
import org.example.productservice.global.error.BaseException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminLLMServiceImpl implements AdminLLMService {

	private final AdminLLMRepository adminLlmRepository;

	@Override
	public void createLLM(AddLLMRequestDto createLLMRequestDto) {

		if (adminLlmRepository.findByLlmName(createLLMRequestDto.getLlmName()).isPresent()) {
			throw new BaseException(BaseResponseStatus.DUPLICATED_DATA);
		}

		adminLlmRepository.save(createLLMRequestDto.toEntity());
	}

	@Override
	public void updateLLM(UpdateLLMRequestDto updateLLMRequestDto) {

		adminLlmRepository.findById(updateLLMRequestDto.getLlmId())
				.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		adminLlmRepository.save(updateLLMRequestDto.toEntity());
	}

	@Override
	public void deleteLLM(DeleteLLMRequestDto deleteLLMRequestDto) {

		LLM llm = adminLlmRepository.findById(deleteLLMRequestDto.getLlmId())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		adminLlmRepository.save(deleteLLMRequestDto.toEntity(llm));

	}

	public List<GetLLMListByTypeResponseDto> getLLMListByType(Long llmTypeId) {

		return adminLlmRepository.findAll().stream()
			.filter(llm -> !llm.isDeleted() && (null == llmTypeId || llm.getLlmTypeId().equals(llmTypeId)))
			.map(GetLLMListByTypeResponseDto::toDto)
			.toList();
	}
}
