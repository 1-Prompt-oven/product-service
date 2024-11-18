package org.example.productservice.admin.llm.application;

import org.example.productservice.admin.llm.infrastructure.AdminLLMVersionRepository;
import org.example.productservice.common.llm.domain.LLMVersion;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@Transactional
@RequiredArgsConstructor
public class LLMVersionInitializer implements ApplicationRunner {

	private final AdminLLMVersionRepository adminLLMVersionRepository;

	@Override
	public void run(ApplicationArguments args) {
		// 기존 데이터가 없을 때만 초기화
		if (adminLLMVersionRepository.count() == 0) {
			// Dall-E 버전들
			createLLMVersion(1L, 1L, "dall-e-2");
			createLLMVersion(2L, 1L, "dall-e-3");

			// GPT 버전들
			createLLMVersion(3L, 2L, "gpt-3.5-turbo");
			createLLMVersion(4L, 2L, "gpt-4");
			createLLMVersion(5L, 2L, "gpt-4-turbo");

			// Midjourney 버전들
			createLLMVersion(6L, 3L, "midjourney-4.0");
			createLLMVersion(7L, 3L, "midjourney-5.0");
			createLLMVersion(8L, 3L, "midjourney-6.0");
		}
	}

	private void createLLMVersion(Long versionId, Long llmId, String versionName) {
		LLMVersion llmVersion = LLMVersion.builder()
			.llmVersionId(versionId)
			.llmId(llmId)
			.llmVersionName(versionName)
			.deleted(false)
			.build();

		adminLLMVersionRepository.save(llmVersion);
	}
}