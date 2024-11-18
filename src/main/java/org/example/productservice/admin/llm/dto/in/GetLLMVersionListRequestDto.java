package org.example.productservice.admin.llm.dto.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class GetLLMVersionListRequestDto {

	private Long llmVersionId;
	private String llmVersionName;
	private Long llmId;
}
