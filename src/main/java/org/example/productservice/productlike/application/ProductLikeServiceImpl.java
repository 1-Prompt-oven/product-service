package org.example.productservice.productlike.application;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.example.productservice.product.domain.Product;
import org.example.productservice.product.dto.out.ProductDto;
import org.example.productservice.product.infrastructure.ProductRepository;
import org.example.productservice.productlike.domain.ProductLike;
import org.example.productservice.productlike.dto.in.GetProductLikeListRequestDto;
import org.example.productservice.productlike.dto.in.UpdateProductLikeRequestDto;
import org.example.productservice.productlike.dto.out.GetLikeInfoResponseDto;
import org.example.productservice.productlike.dto.out.GetProductLikeListResponseDto;
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
	private final ProductRepository productRepository;

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

	@Override
	public GetProductLikeListResponseDto getLikedProductList(GetProductLikeListRequestDto requestDto) {
		List<ProductLike> productLikes = findProductLikes(requestDto);

		// 다음 페이지 여부 확인 및 리스트 자르기
		boolean hasNext = productLikes.size() > requestDto.getPageSize();
		if (hasNext) {
			productLikes = productLikes.subList(0, requestDto.getPageSize());
		}

		// 상품 정보 조회 및 변환
		List<ProductDto> productDtoList = findProducts(productLikes);

		String nextCursorId = null;
		if (hasNext && !productLikes.isEmpty()) {
			nextCursorId = String.valueOf(productLikes.getLast().getProductLikeId());
		}

		return GetProductLikeListResponseDto.builder()
			.productList(productDtoList)
			.nextCursorId(nextCursorId)
			.hasNext(hasNext)
			.build();
	}

	private List<ProductLike> findProductLikes(GetProductLikeListRequestDto requestDto) {
		if ("DESC".equals(requestDto.getSortOption())) {
			return productLikeRepository.findLikedProductsByMemberUuidWithCursorDesc(
				requestDto.getMemberUuid(),
				requestDto.getCursorId(),
				requestDto.getPageSize() + 1
			);
		}

		return productLikeRepository.findLikedProductsByMemberUuidWithCursorAsc(
			requestDto.getMemberUuid(),
			requestDto.getCursorId(),
			requestDto.getPageSize() + 1
		);
	}

	private List<ProductDto> findProducts(List<ProductLike> productLikes) {
		List<String> productUuids = productLikes.stream()
			.map(ProductLike::getProductUuid)
			.toList();

		Map<String, Product> productMap = productRepository.findAllByProductUuidIn(productUuids)
			.stream()
			.collect(Collectors.toMap(
				Product::getProductUuid,
				product -> product
			));

		return productLikes.stream()
			.map(like -> productMap.get(like.getProductUuid()))
			.filter(Objects::nonNull)
			.map(productLikeMapper::productToDto)
			.toList();
	}
}
