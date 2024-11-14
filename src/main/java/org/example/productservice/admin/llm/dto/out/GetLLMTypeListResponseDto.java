package org.example.productservice.admin.llm.dto.out;

import org.example.productservice.admin.llm.vo.out.GetLLMTypeListResponseVo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetLLMTypeListResponseDto {

	private Long llmTypeId;

	private String name;

	public static GetLLMTypeListResponseDto toDto(Long llmTypeId, String name) {
		return GetLLMTypeListResponseDto.builder()
				.llmTypeId(llmTypeId)
				.name(name)
				.build();
	}

	public GetLLMTypeListResponseVo toVo() {
		return GetLLMTypeListResponseVo.builder()
				.llmTypeId(llmTypeId)
				.name(name)
				.build();
	}
}
