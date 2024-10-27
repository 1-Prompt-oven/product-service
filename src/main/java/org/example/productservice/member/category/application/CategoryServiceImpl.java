package org.example.productservice.member.category.application;

import java.util.List;

import org.example.productservice.member.category.dto.out.GetSubCategoriesResponseDto;
import org.example.productservice.member.category.infrastructure.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;

	@Transactional(readOnly = true)
	@Override
	public List<GetSubCategoriesResponseDto> getSubCategories(String parentCategoryUuid) {

		if (parentCategoryUuid.equals("top")) {
			// 최상위 카테고리를 가져옴
			return categoryRepository.findByParentCategoryUuidIsNull()
				.stream()
				.filter(category -> !category.isDeleted())
				.map(GetSubCategoriesResponseDto::from)
				.toList();
		}

		return categoryRepository.findByParentCategoryUuid(parentCategoryUuid)
			.stream()
			.filter(category -> !category.isDeleted())
			.map(GetSubCategoriesResponseDto::from)
			.toList();
	}

}
