package org.example.productservice.admin.llm.presentation;

import java.util.List;

import org.example.productservice.admin.llm.application.AdminLLMTypeService;
import org.example.productservice.admin.llm.dto.in.AddLLMTypeRequestDto;
import org.example.productservice.admin.llm.dto.out.GetLLMTypeListResponseDto;
import org.example.productservice.admin.llm.vo.in.AddLLMTypeRequestVo;
import org.example.productservice.admin.llm.vo.out.GetLLMTypeListResponseVo;
import org.example.productservice.global.common.response.BaseResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/admin/llm/type")
@Tag(name = "LLM 타입 관리 API", description = "LLM 타입 관련 API endpoints")
public class AdminLLMTypeController {

	private final AdminLLMTypeService adminLLMTypeService;

	@Operation(summary = "LLM 타입 생성", description = "LLM 타입 생성")
	@PostMapping
	public BaseResponse<Void> addLLMType(@RequestBody AddLLMTypeRequestVo addLLMTypeRequestVo) {

		adminLLMTypeService.addLLMType(AddLLMTypeRequestDto.toDto(addLLMTypeRequestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "LLM 타입 수정", description = "LLM 타입 수정")
	@PutMapping("/{llmTypeId}")
	public BaseResponse<Void> updateLLMType(@PathVariable Long llmTypeId,
		@RequestBody AddLLMTypeRequestVo addLLMTypeRequestVo) {

		adminLLMTypeService.updateLLMType(llmTypeId, AddLLMTypeRequestDto.toDto(addLLMTypeRequestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "LLM 타입 삭제", description = "LLM 타입 삭제")
	@DeleteMapping("/{llmTypeId}")
	public BaseResponse<Void> deleteLLMType(@PathVariable Long llmTypeId) {

		adminLLMTypeService.deleteLLMType(llmTypeId);
		return new BaseResponse<>();
	}

	@Operation(summary = "LLM 타입 리스트 조회")
	@GetMapping("/list")
	public BaseResponse<List<GetLLMTypeListResponseVo>> getLLMTypeList() {

		List<GetLLMTypeListResponseDto> llmTypeList = adminLLMTypeService.getLLMTypeList();
		return new BaseResponse<>(
			llmTypeList.stream()
				.map(GetLLMTypeListResponseDto::toVo)
				.toList()
		);
	}

}
