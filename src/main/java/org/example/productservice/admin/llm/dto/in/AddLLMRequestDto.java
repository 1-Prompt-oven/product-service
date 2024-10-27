package org.example.productservice.admin.llm.dto.in;

import org.example.productservice.admin.llm.vo.in.AddLLMRequestVo;
import org.example.productservice.common.domain.LLM;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddLLMRequestDto {

	private String name;

	public AddLLMRequestDto(String name) {
		this.name = name;
	}

	public static AddLLMRequestDto toDto(AddLLMRequestVo addLLMRequestVo) {
		return new AddLLMRequestDto(addLLMRequestVo.getName());
	}

	public LLM toEntity() {
		return LLM.builder()
				.name(name)
				.deleted(false)
				.build();
	}
}
