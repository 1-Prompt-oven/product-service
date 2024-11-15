package org.example.productservice.admin.llm.application;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.productservice.admin.llm.infrastructure.AdminLLMRepository;
import org.example.productservice.admin.llm.infrastructure.AdminLLMTypeRepository;
import org.example.productservice.common.llm.domain.LLM;
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
@Order(2)
public class LLMDataInitializer implements ApplicationListener<ApplicationReadyEvent> {

	private final AdminLLMRepository adminLlmRepository;
	private final AdminLLMTypeRepository adminLLMTypeRepository;

	@Override
	@Transactional
	public void onApplicationEvent(ApplicationReadyEvent event) {
		initializeLLMData();
	}

	private void initializeLLMData() {
		if (adminLlmRepository.count() > 0) {
			log.info("LLM data already exists. Skip initializing LLM data.");
			return;
		}

		Map<String, String> llmTypeMap = new HashMap<>();
		llmTypeMap.put("GPT", "text");
		llmTypeMap.put("Midjourney", "image");
		llmTypeMap.put("Dall-E", "image");

		try {
			List<LLM> llms = llmTypeMap.entrySet().stream()
				.map(entry -> {
					String llmName = entry.getKey();
					String typeName = entry.getValue();
					LLMType llmType = adminLLMTypeRepository.findByLlmTypeName(typeName)
						.orElseThrow(() -> new RuntimeException("LLMType not found: " + typeName));

					return LLM.builder()
						.llmName(llmName)
						.llmTypeId(llmType.getLlmTypeId())
						.llmTypeName(llmType.getLlmTypeName())
						.deleted(false)
						.build();
				})
				.toList();

			adminLlmRepository.saveAll(llms);
			log.info("Successfully initialized {} LLM entries", llms.size());
		} catch (Exception e) {
			log.error("Failed to initialize LLM data", e);
			throw e;
		}
	}
}