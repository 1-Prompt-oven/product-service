package org.example.productservice.llm.application;

import java.util.List;

import org.example.productservice.llm.dto.in.AddLLMRequestDto;
import org.example.productservice.llm.dto.in.DeleteLLMRequestDto;
import org.example.productservice.llm.dto.out.GetLLMListByTypeResponseDto;
import org.example.productservice.llm.infrastructure.AdminLLMRepository;
import org.example.productservice.llm.domain.LLM;
import org.example.productservice.common.response.BaseResponseStatus;
import org.example.productservice.common.error.BaseException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LLMServiceImpl implements LLMService {

	private final AdminLLMRepository adminLlmRepository;

	@Override
	public void createLLM(AddLLMRequestDto addLLMRequestDto) {

		if (adminLlmRepository.findByLlmName(addLLMRequestDto.getLlmName()).isPresent()) {
			throw new BaseException(BaseResponseStatus.DUPLICATED_DATA);
		}

		adminLlmRepository.save(addLLMRequestDto.createEntity());
	}

	@Override
	public void updateLLM(Long llmId, AddLLMRequestDto addLLMRequestDto) {

		adminLlmRepository.save(addLLMRequestDto.updateEntity(llmId));
	}

	@Override
	public void deleteLLM(DeleteLLMRequestDto deleteLLMRequestDto) {

		LLM llm = adminLlmRepository.findById(deleteLLMRequestDto.getLlmId())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		adminLlmRepository.save(deleteLLMRequestDto.toEntity(llm));

	}

	public List<GetLLMListByTypeResponseDto> getLLMListByType(String llmType) {
		return adminLlmRepository.findAllByTypeAndNotDeleted(llmType).stream()
			.map(GetLLMListByTypeResponseDto::toDto)
			.toList();
	}
}
