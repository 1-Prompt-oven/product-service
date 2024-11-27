package org.example.productservice.productlike.application;

import org.example.productservice.productlike.domain.ProductLike;
import org.example.productservice.productlike.dto.in.UpdateProductLikeRequestDto;
import org.example.productservice.productlike.dto.out.GetLikeInfoResponseDto;
import org.example.productservice.productlike.infrastructure.ProductLikeRepository;
import org.example.productservice.productlike.mapper.ProductLikeMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductLikeServiceImpl implements ProductLikeService {

	private final ProductLikeMapper productLikeMapper;
	private final ProductLikeRepository productLikeRepository;

	@Override
	public void toggleProductLike(UpdateProductLikeRequestDto updateProductLikeRequestDto) {

		ProductLike productLike = productLikeRepository.findByMemberUuidAndProductUuid(
			updateProductLikeRequestDto.getMemberUuid(), updateProductLikeRequestDto.getProductUuid())
			.map(productLikeMapper::updateEntity)
			.orElse(productLikeMapper.createEntity(updateProductLikeRequestDto));

		productLikeRepository.save(productLike);
	}

	@Override
	public GetLikeInfoResponseDto getProductLikeInfo(String memberUuid, String productUuid) {

		return productLikeRepository.findByMemberUuidAndProductUuid(memberUuid, productUuid)
			.map(productLikeMapper::toDto)
			.orElse(GetLikeInfoResponseDto.builder()
				.liked(false)
				.build());
	}
}
