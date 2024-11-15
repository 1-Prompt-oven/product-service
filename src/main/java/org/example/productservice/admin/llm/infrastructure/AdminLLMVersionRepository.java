package org.example.productservice.admin.llm.infrastructure;

import java.util.List;

import org.example.productservice.common.llm.domain.LLMVersion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminLLMVersionRepository extends JpaRepository<LLMVersion, Long> {

	boolean existsByLlmVersionName(String llmVersionName);

	List<LLMVersion> findByLlmIdAndDeletedFalse(Long llmId);
}
