package org.example.productservice.admin.llm.application;

import java.util.List;

import org.example.productservice.admin.llm.dto.in.AddLLMRequestDto;
import org.example.productservice.admin.llm.dto.in.DeleteLLMRequestDto;
import org.example.productservice.admin.llm.dto.in.UpdateLLMRequestDto;
import org.example.productservice.admin.llm.dto.out.GetAllLLMResponseDto;
import org.example.productservice.admin.llm.infrastructure.LLMRepository;
import org.example.productservice.common.llm.domain.LLM;
import org.example.productservice.global.common.response.BaseResponseStatus;
import org.example.productservice.global.error.BaseException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminLLMServiceImpl implements AdminLLMService {

	private final LLMRepository llmRepository;

	@Override
	public void createLLM(AddLLMRequestDto createLLMRequestDto) {

		if (llmRepository.findByName(createLLMRequestDto.getName()).isPresent()) {
			throw new BaseException(BaseResponseStatus.DUPLICATED_DATA);
		}

		llmRepository.save(createLLMRequestDto.toEntity());
	}

	@Override
	public void updateLLM(UpdateLLMRequestDto updateLLMRequestDto) {

		llmRepository.findById(updateLLMRequestDto.getLlmId())
				.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		llmRepository.save(updateLLMRequestDto.toEntity());
	}

	@Override
	public void deleteLLM(DeleteLLMRequestDto deleteLLMRequestDto) {

		LLM llm = llmRepository.findById(deleteLLMRequestDto.getLlmId())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		llmRepository.save(deleteLLMRequestDto.toEntity(llm));

	}

	@Override
	public List<GetAllLLMResponseDto> getAllLLM() {

		return llmRepository.findAll().stream()
				.filter(llm -> !llm.isDeleted())
				.map(GetAllLLMResponseDto::toDto)
				.toList();
	}
}
