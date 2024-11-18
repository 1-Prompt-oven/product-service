package org.example.productservice.llm.presentation;

import java.util.List;

import org.example.productservice.llm.application.LLMVersionService;
import org.example.productservice.llm.dto.in.AddLLMVersionRequestDto;
import org.example.productservice.llm.vo.in.AddLLMVersionRequestVo;
import org.example.productservice.llm.vo.out.GetLLMVersionListRequestVo;
import org.example.productservice.common.response.BaseResponse;
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
@RequestMapping("/v1/admin/llm/version")
@Tag(name = "LLM 버전 관리", description = "LLM 버전 관리 API")
public class LLMVersionManageController {

	private final LLMVersionService LLMVersionService;

	@Operation(summary = "LLM 버전 생성", description = "LLM 버전 생성")
	@PostMapping
	public BaseResponse<Void> addLLMVersion(
		@RequestBody AddLLMVersionRequestVo addLLMVersionRequestVo) {

		LLMVersionService.addLLMVersion(AddLLMVersionRequestDto.toDto(addLLMVersionRequestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "LLM 버전 수정", description = "LLM 버전 수정")
	@PutMapping("/{llmVersionId}")
	public BaseResponse<Void> updateLLMVersion(
		@PathVariable Long llmVersionId, @RequestBody AddLLMVersionRequestVo addLLMVersionRequestVo) {

		LLMVersionService.updateLLMVersion(llmVersionId, AddLLMVersionRequestDto.toDto(addLLMVersionRequestVo));
		return new BaseResponse<>();
	}

	@Operation(summary = "LLM 버전 삭제", description = "LLM 버전 삭제")
	@DeleteMapping("/{llmVersionId}")
	public BaseResponse<Void> deleteLLMVersion(@PathVariable Long llmVersionId) {

		LLMVersionService.deleteLLMVersion(llmVersionId);
		return new BaseResponse<>();
	}

	@Operation(summary = "LLM 버전 리스트 조회", description = """
	LLM ID 매칭 정보
	- llmId = 1: Dall-E (image)
	- llmId = 2: GPT (text)
	""")
	@GetMapping("/{llmId}")
	public BaseResponse<List<GetLLMVersionListRequestVo>> getLLMVersionListByLLMId(@PathVariable Long llmId) {

		return new BaseResponse<>(
			LLMVersionService.getLLMVersionListByLLMId(llmId)
				.stream()
				.map(llmVersionDto -> GetLLMVersionListRequestVo.builder()
					.llmVersionId(llmVersionDto.getLlmVersionId())
					.llmVersionName(llmVersionDto.getLlmVersionName())
					.build()
				)
				.toList()
		);
	}
}
