package org.example.productservice.admin.llm.presentation;

import java.util.List;

import org.example.productservice.admin.llm.application.AdminLLMService;
import org.example.productservice.admin.llm.dto.in.AddLLMRequestDto;
import org.example.productservice.admin.llm.dto.in.DeleteLLMRequestDto;
import org.example.productservice.admin.llm.dto.in.UpdateLLMRequestDto;
import org.example.productservice.admin.llm.dto.out.GetLLMListByTypeResponseDto;
import org.example.productservice.admin.llm.vo.in.AddLLMRequestVo;
import org.example.productservice.admin.llm.vo.in.DeleteLLMRequestVo;
import org.example.productservice.admin.llm.vo.in.UpdateLLMRequestVo;
import org.example.productservice.admin.llm.vo.out.GetLLMListByTypeResponseVo;
import org.example.productservice.global.common.response.BaseResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/admin/llm")
@Tag(name = "LLM 관리 API", description = "LLM 관련 API endpoints")
public class AdminLLMController {

	private final AdminLLMService adminLLMService;

	@Operation(summary = "LLM 생성", description = "LLM 생성")
	@PostMapping
	public BaseResponse<Void> addLLM(@RequestBody AddLLMRequestVo addLLMRequestVo) {

		adminLLMService.createLLM(AddLLMRequestDto.toDto(addLLMRequestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "LLM 수정", description = "LLM 수정")
	@PutMapping
	public BaseResponse<Void> updateLLM(@RequestBody UpdateLLMRequestVo updateLLMRequestVo) {

		adminLLMService.updateLLM(UpdateLLMRequestDto.toDto(updateLLMRequestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "LLM 삭제", description = "LLM 삭제")
	@DeleteMapping
	public BaseResponse<Void> deleteLLM(@RequestBody DeleteLLMRequestVo deleteLLMRequestVo) {

		adminLLMService.deleteLLM(DeleteLLMRequestDto.toDto(deleteLLMRequestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "LLM 리스트 조회", description = "llmTypeId = 1(text형 llm 리스트), 2(image형 llm 리스트), 공백(전체 llm 리스트)")
	@GetMapping("/list")
	public BaseResponse<List<GetLLMListByTypeResponseVo>> getLLMListByType(
		@RequestParam(required = false) Long llmTypeId) {

		return new BaseResponse<>(
			adminLLMService.getLLMListByType(llmTypeId).stream()
				.map(GetLLMListByTypeResponseDto::toVo)
				.toList()
		);
	}
}
