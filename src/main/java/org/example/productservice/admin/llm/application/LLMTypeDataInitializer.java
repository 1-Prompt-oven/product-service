package org.example.productservice.admin.llm.application;

import java.util.Arrays;
import java.util.List;

import org.example.productservice.admin.llm.infrastructure.AdminLLMTypeRepository;
import org.example.productservice.common.llm.domain.LLMType;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
@Transactional
@Order(1)
public class LLMTypeDataInitializer implements ApplicationListener<ApplicationReadyEvent> {

	private final AdminLLMTypeRepository adminLLMTypeRepository;

	@Override

	public void onApplicationEvent(ApplicationReadyEvent event) {
		initializeLLMTypeData();
	}

	private void initializeLLMTypeData() {
		if (adminLLMTypeRepository.count() > 0) {
			log.info("LLMType data already exists. Skip initializing LLMType data.");
			return;
		}

		List<String> typeNames = Arrays.asList("text", "image");

		try {
			List<LLMType> types = typeNames.stream()
				.map(llmTypeName -> LLMType.builder()
					.llmTypeName(llmTypeName)
					.deleted(false)
					.build())
				.toList();

			adminLLMTypeRepository.saveAll(types);
			log.info("Successfully initialized {} LLMType entries", types.size());
		} catch (Exception e) {
			log.error("Failed to initialize LLMType data", e);
			throw e;
		}
	}
}