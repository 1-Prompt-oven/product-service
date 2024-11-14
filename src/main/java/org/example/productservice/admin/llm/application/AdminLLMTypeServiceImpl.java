package org.example.productservice.admin.llm.application;

import java.util.List;

import org.example.productservice.admin.llm.dto.in.AddLLMTypeRequestDto;
import org.example.productservice.admin.llm.dto.out.GetLLMTypeListResponseDto;
import org.example.productservice.admin.llm.infrastructure.AdminLLMTypeRepository;
import org.example.productservice.common.llm.domain.LLMType;
import org.example.productservice.global.common.response.BaseResponseStatus;
import org.example.productservice.global.error.BaseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
@RequestMapping("/v1/admin/llm/type")
@Tag(name = "LLM 타입 관리 API", description = "LLM 타입 관련 API endpoints")
public class AdminLLMTypeServiceImpl implements AdminLLMTypeService {

	private final AdminLLMTypeRepository adminLLMTypeRepository;

	@Override
	public void addLLMType(AddLLMTypeRequestDto addLLMTypeRequestDto) {

		if (adminLLMTypeRepository.existsByName(addLLMTypeRequestDto.getName())) {
			throw new BaseException(BaseResponseStatus.DUPLICATED_DATA);
		}

		adminLLMTypeRepository.save(addLLMTypeRequestDto.createEntity());
	}

	@Override
	public void updateLLMType(Long llmTypeId, AddLLMTypeRequestDto addLLMTypeRequestDto) {

		adminLLMTypeRepository.save(addLLMTypeRequestDto.updateEntity(llmTypeId));
	}

	@Override
	public void deleteLLMType(Long llmTypeId) {

		adminLLMTypeRepository.save(LLMType.builder()
			.llmTypeId(llmTypeId)
			.deleted(true)
			.build());
	}

	@Override
	public List<GetLLMTypeListResponseDto> getLLMTypeList() {

		return adminLLMTypeRepository.findAll().stream()
			.filter(llmType -> !llmType.isDeleted())
			.map(llmType -> GetLLMTypeListResponseDto.builder()
				.llmTypeId(llmType.getLlmTypeId())
				.name(llmType.getName())
				.build())
			.toList();
	}

}
