package org.example.productservice.llm.infrastructure;

import java.util.List;

import org.example.productservice.llm.domain.LLMVersion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LLMVersionRepository extends JpaRepository<LLMVersion, Long> {

	List<LLMVersion> findByLlmIdAndDeletedFalse(Long llmId);
}
