package org.example.productservice.admin.llm.infrastructure;

import org.example.productservice.common.llm.domain.LLMType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminLLMTypeRepository extends JpaRepository<LLMType, Long> {
	boolean existsByName(String name);
}
