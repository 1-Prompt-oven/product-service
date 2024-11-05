package org.example.productservice.admin.category.application;

import java.util.Arrays;
import java.util.List;

import org.example.productservice.admin.llm.infrastructure.LLMRepository;
import org.example.productservice.common.domain.LLM;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class LLMDataInitializer implements ApplicationListener<ApplicationReadyEvent> {

	private final LLMRepository llmRepository;

	/**
	 * LLM 데이터 초기화
	 */


	@Override
	@Transactional
	public void onApplicationEvent(ApplicationReadyEvent event) {
		initializeLLMData();
	}

	private void initializeLLMData() {

		if (llmRepository.count() > 0) {
			log.info("LLM data already exists. Skip initializing LLM data.");
			return;
		}

		List<String> llmNames = Arrays.asList(
			"Midjourney",
			"Dall-E",
			"Stable Diffusion",
			"GPT"
		);

		try {
			List<LLM> llms = llmNames.stream()
				.map(name -> LLM.builder()
					.name(name)
					.deleted(false)
					.build())
				.toList();

			llmRepository.saveAll(llms);
			log.info("Successfully initialized {} LLM entries", llms.size());
		} catch (Exception e) {
			log.error("Failed to initialize LLM data", e);
			throw e;
		}
	}
}
