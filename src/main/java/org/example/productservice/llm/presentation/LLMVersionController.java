package org.example.productservice.llm.presentation;

import java.util.List;

import org.example.productservice.common.response.BaseResponse;
import org.example.productservice.llm.application.LLMVersionService;
import org.example.productservice.llm.vo.out.GetLLMVersionListRequestVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/admin/product/llm/version")
@Tag(name = "LLM 버전 관리", description = "LLM 버전 관리 API")
public class LLMVersionController {

	private final LLMVersionService llmVersionService;


	@Operation(summary = "LLM 버전 리스트 조회", description = """
	LLM ID 매칭 정보
	- llmId = 1: Dall-E (image)
	- llmId = 2: GPT (text)
	""")
	@GetMapping("/{llmId}")
	public BaseResponse<List<GetLLMVersionListRequestVo>> getLLMVersionListByLLMId(@PathVariable Long llmId) {

		return new BaseResponse<>(
			llmVersionService.getLLMVersionListByLLMId(llmId)
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
