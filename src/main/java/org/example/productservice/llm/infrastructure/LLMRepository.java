package org.example.productservice.llm.infrastructure;

import java.util.List;

import org.example.productservice.llm.domain.LLM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LLMRepository extends JpaRepository<LLM, Long> {

	@Query("SELECT l FROM LLM l WHERE l.deleted = false " +
		"AND (:llmType IS NULL OR l.llmType = :llmType)")
	List<LLM> findAllByTypeAndNotDeleted(String llmType);
}
