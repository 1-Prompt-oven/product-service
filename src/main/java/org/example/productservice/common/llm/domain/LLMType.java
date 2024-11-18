package org.example.productservice.common.llm.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
public class LLMType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long llmTypeId;

	private String llmTypeName;

	private boolean deleted;
}
