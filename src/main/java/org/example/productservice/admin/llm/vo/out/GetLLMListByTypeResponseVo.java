package org.example.productservice.admin.llm.vo.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetLLMListByTypeResponseVo {

	private Long llmId;
	private String llmName;
	private Long llmTypeId;
	private String llmTypeName;

}
