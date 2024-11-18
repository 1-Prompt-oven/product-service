package org.example.productservice.admin.llm.vo.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class DeleteLLMRequestVo {

	private Long llmId;
}
