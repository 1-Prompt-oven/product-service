<<<<<<<< HEAD:src/main/java/org/example/productservice/common/domain/LLM.java
package org.example.productservice.common.domain;
========
package org.example.productservice.llm.domain;
>>>>>>>> develop:src/main/java/org/example/productservice/llm/domain/LLM.java

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

<<<<<<<< HEAD:src/main/java/org/example/productservice/common/domain/LLM.java
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
========
	@Column(nullable = false)
	private String llmType;
>>>>>>>> develop:src/main/java/org/example/productservice/llm/domain/LLM.java
}
