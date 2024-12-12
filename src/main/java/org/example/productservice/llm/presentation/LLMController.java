package org.example.productservice.llm.presentation;

import java.util.List;

import org.example.productservice.common.response.BaseResponse;
import org.example.productservice.llm.application.LLMService;
import org.example.productservice.llm.dto.out.GetLLMListByTypeResponseDto;
import org.example.productservice.llm.llmMapper.LLMMapper;
import org.example.productservice.llm.vo.out.GetLLMNameByLLMIdResponseVo;
import org.example.productservice.llm.vo.out.GetLLMListByTypeResponseVo;
import org.example.productservice.llm.vo.out.GetLLMNameByProductUuidResponseVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/product/llm")
@Tag(name = "LLM 관리 API", description = "LLM 관리 관련 API endpoints")
public class LLMController {

	private final LLMService llmService;
	private final LLMMapper	llmMapper;

	@Operation(summary = "LLM 리스트 조회", description = """
	llmType = text, image, 미작성 시 전체 리스트 조회
	""")
	@GetMapping("/list")
	public BaseResponse<List<GetLLMListByTypeResponseVo>> getLLMListByType(
		@RequestParam(required = false) String llmType) {

		return new BaseResponse<>(
			llmService.getLLMListByType(llmType).stream()
				.map(GetLLMListByTypeResponseDto::toVo)
				.toList()
		);
	}

	@Operation(summary = "LLM 이름 조회", description = "llmId에 해당하는 LLM 이름 조회")
	@GetMapping("/{llmId}")
	public BaseResponse<GetLLMNameByLLMIdResponseVo> getLLMNameByLLMId(
		@PathVariable Long llmId) {

		return new BaseResponse<>(
			llmMapper.toVo(llmService.getLLMNameByLLMId(llmId))
		);
	}

	@Operation(summary = "LLM 이름 조회", description = "productUuid에 해당하는 LLM 이름 조회")
	@GetMapping("/product")
	public BaseResponse<GetLLMNameByProductUuidResponseVo> getLLMNameByProductUuid(
		@RequestParam String productUuid) {

		return new BaseResponse<>(
			llmMapper.toVo(llmService.getLLMNameByProductUuid(productUuid))
		);
	}
}
