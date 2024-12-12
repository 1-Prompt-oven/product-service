package org.example.productservice.llm.application;

import java.util.List;

import org.example.productservice.common.error.BaseException;
import org.example.productservice.common.response.BaseResponseStatus;
import org.example.productservice.llm.domain.LLM;
import org.example.productservice.llm.dto.out.GetLLMListByTypeResponseDto;
import org.example.productservice.llm.dto.out.GetLLMNameByLLMIdResponseDto;
import org.example.productservice.llm.dto.out.GetLLMNameByProductUuidResponseDto;
import org.example.productservice.llm.infrastructure.LLMRepository;
import org.example.productservice.llm.llmMapper.LLMMapper;
import org.example.productservice.product.domain.Product;
import org.example.productservice.product.infrastructure.ProductRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LLMServiceImpl implements LLMService {

	private final LLMRepository llmRepository;
	private final ProductRepository productRepository;
	private final LLMMapper llmMapper;

	public List<GetLLMListByTypeResponseDto> getLLMListByType(String llmType) {
		return llmRepository.findAllByTypeAndNotDeleted(llmType).stream()
			.map(GetLLMListByTypeResponseDto::toDto)
			.toList();
	}

	@Override
	public GetLLMNameByLLMIdResponseDto getLLMNameByLLMId(Long llmId) {

		LLM llm = llmRepository.findById(llmId)
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		return llmMapper.toDto(llm);
	}

	@Override
	public GetLLMNameByProductUuidResponseDto getLLMNameByProductUuid(String productUuid) {

		Product product = productRepository.findByProductUuid(productUuid)
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA));

		String llmName = llmRepository.findById(product.getLlmId())
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DATA))
			.getLlmName();

		return llmMapper.toDto(llmName);
	}
}
