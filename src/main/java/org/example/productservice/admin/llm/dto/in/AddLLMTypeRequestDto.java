package org.example.productservice.admin.llm.dto.in;

import org.example.productservice.admin.llm.vo.in.AddLLMTypeRequestVo;
import org.example.productservice.common.llm.domain.LLMType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class AddLLMTypeRequestDto {

	private String llmTypeName;

	public static AddLLMTypeRequestDto toDto(AddLLMTypeRequestVo addLLMTypeRequestVo) {
		return AddLLMTypeRequestDto.builder()
				.llmTypeName(addLLMTypeRequestVo.getName())
				.build();
	}

	public LLMType createEntity() {
		return LLMType.builder()
				.llmTypeName(llmTypeName)
				.build();
	}

	public LLMType updateEntity(Long llmTypeId) {
		return LLMType.builder()
				.llmTypeId(llmTypeId)
				.llmTypeName(llmTypeName)
				.build();
	}
}
