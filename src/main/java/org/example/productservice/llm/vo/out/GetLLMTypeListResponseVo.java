package org.example.productservice.llm.vo.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class GetLLMTypeListResponseVo {

	private Long llmTypeId;

	private String name;
}
