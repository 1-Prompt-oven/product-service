package org.example.productservice.common.llm.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class LLM {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long llmId;

	@Column(nullable = false, length = 20)
	private String name;

	@Column(nullable = false)
	private boolean deleted;

	@Builder
	public LLM(Long llmId, String name, boolean deleted) {
		this.llmId = llmId;
		this.name = name;
		this.deleted = deleted;
	}

	@Builder
	public LLM(String name, boolean deleted) {
		this.name = name;
		this.deleted = deleted;
	}
}
