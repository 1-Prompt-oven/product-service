package org.example.productservice.llm.application;

import java.util.List;

import org.example.productservice.llm.infrastructure.AdminLLMRepository;
import org.example.productservice.llm.infrastructure.AdminLLMVersionRepository;
import org.example.productservice.llm.domain.LLM;
import org.example.productservice.llm.domain.LLMVersion;
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
	private final AdminLLMVersionRepository adminLLMVersionRepository;

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

		try {
			// LLM 데이터 초기화
			LLM dallE = LLM.builder()
				.llmName("Dall-E")
				.llmType("image")
				.deleted(false)
				.build();

			LLM gpt = LLM.builder()
				.llmName("GPT")
				.llmType("text")
				.deleted(false)
				.build();

			List<LLM> savedLlms = adminLlmRepository.saveAll(List.of(dallE, gpt));

			// LLM 버전 데이터 초기화
			Long dallEId = savedLlms.get(0).getLlmId();
			Long gptId = savedLlms.get(1).getLlmId();

			List<LLMVersion> versions = List.of(
				// Dall-E 버전들
				LLMVersion.builder()
					.llmVersionName("dall-e-2")
					.llmId(dallEId)
					.deleted(false)
					.build(),
				LLMVersion.builder()
					.llmVersionName("dall-e-3")
					.llmId(dallEId)
					.deleted(false)
					.build(),

				// GPT 버전들
				LLMVersion.builder()
					.llmVersionName("gpt-3.5-turbo")
					.llmId(gptId)
					.deleted(false)
					.build(),
				LLMVersion.builder()
					.llmVersionName("gpt-4")
					.llmId(gptId)
					.deleted(false)
					.build(),
				LLMVersion.builder()
					.llmVersionName("gpt-4-turbo")
					.llmId(gptId)
					.deleted(false)
					.build()
			);

			adminLLMVersionRepository.saveAll(versions);

			log.info("Successfully initialized {} LLMs with {} versions",
				savedLlms.size(), versions.size());

		} catch (Exception e) {
			log.error("Failed to initialize LLM data", e);
			throw e;
		}
	}
}