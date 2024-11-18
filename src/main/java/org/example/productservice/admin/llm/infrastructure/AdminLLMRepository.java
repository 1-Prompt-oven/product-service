package org.example.productservice.admin.llm.infrastructure;

import java.util.Optional;

import org.example.productservice.common.llm.domain.LLM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminLLMRepository extends JpaRepository<LLM, Long> {
	Optional<LLM> findByLlmName(String llmName);
}
