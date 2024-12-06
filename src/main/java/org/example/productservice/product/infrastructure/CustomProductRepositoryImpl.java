package org.example.productservice.product.infrastructure;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.example.productservice.product.domain.Product;
import org.example.productservice.product.dto.in.GetProductListRequestDto;
import org.example.productservice.product.dto.in.GetSellersProductListRequestDto;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class CustomProductRepositoryImpl implements CustomProductRepository {

	private final MongoTemplate mongoTemplate;

	public CustomProductRepositoryImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public List<Product> findProductListWithCursor(GetProductListRequestDto dto, int pageSize) {
		List<Criteria> andCriterias = new ArrayList<>();  // 모든 AND 조건을 담을 리스트

		// 기본 필터 조건
		andCriterias.add(Criteria.where("deleted").is(false));
		andCriterias.add(Criteria.where("temporaryEnrolled").is(false));  // temporaryEnrolled가 false인 항목만 필터링


		// 검색어 필터
		if (StringUtils.hasText(dto.getSearchBar())) {
			andCriterias.add(Criteria.where("productName").regex(dto.getSearchBar(), "i"));
		}

		// 카테고리 필터
		if (StringUtils.hasText(dto.getTopCategoryUuid())) {
			andCriterias.add(Criteria.where("topCategoryUuid").is(dto.getTopCategoryUuid()));
		}
		if (StringUtils.hasText(dto.getSubCategoryUuid())) {
			andCriterias.add(Criteria.where("subCategoryUuid").is(dto.getSubCategoryUuid()));
		}

		// 활성화 상태 필터
		if (dto.getEnable() != null) {
			andCriterias.add(Criteria.where("enabled").is(dto.getEnable()));
		}

		// 가격 범위 필터
		if (StringUtils.hasText(dto.getMinPrice())) {
			andCriterias.add(Criteria.where("price").gte(Double.parseDouble(dto.getMinPrice())));
		}
		if (StringUtils.hasText(dto.getMaxPrice()) && !"max".equals(dto.getMaxPrice())) {
			andCriterias.add(Criteria.where("price").lte(Double.parseDouble(dto.getMaxPrice())));
		}

		// LLM 필터
		if (dto.getLlmIdList() != null && !dto.getLlmIdList().isEmpty()) {
			andCriterias.add(Criteria.where("llmId").in(dto.getLlmIdList()));
		}
		// 커서 기반 페이징
		if (StringUtils.hasText(dto.getCursorId())) {
			Document cursorDoc = mongoTemplate.findById(dto.getCursorId(), Document.class, "products");
			if (cursorDoc != null) {
				String sortField = getSortField(dto.getSortOption());
				Object cursorValue = getCursorValue(cursorDoc, dto.getSortOption());
				Object createdAt = cursorDoc.get("createdAt");

				boolean isAsc = "ASC".equals(dto.getSortBy());

				// 정렬 방향에 따라 비교 연산자 변경
				Criteria cursorCriteria = new Criteria().orOperator(
					new Criteria().andOperator(
						Criteria.where(sortField).is(cursorValue),
						Criteria.where("createdAt").lt(createdAt)
					),
					isAsc ?
						Criteria.where(sortField).gt(cursorValue) :
						Criteria.where(sortField).lt(cursorValue)
				);
				andCriterias.add(cursorCriteria);
			}
		}

		// 모든 조건을 하나의 Criteria로 결합
		Criteria finalCriteria = new Criteria().andOperator(andCriterias.toArray(new Criteria[0]));

		// 정렬 조건 설정
		Sort sort = createSort(dto.getSortOption(), dto.getSortBy());

		Query query = Query.query(finalCriteria)
			.with(sort)
			.limit(pageSize);

		return mongoTemplate.find(query, Product.class);
	}

	@Override
	public List<Product> findSellersProductListWithCursor(GetSellersProductListRequestDto requestDto,
		int pageSize) {

		List<Criteria> andCriterias = new ArrayList<>();

		// 기본 필터 조건
		andCriterias.add(Criteria.where("deleted").is(false));

		// 검색어 필터 (productName)
		if (StringUtils.hasText(requestDto.getSearchBar())) {
			andCriterias.add(Criteria.where("productName").regex(requestDto.getSearchBar(), "i"));
		}

		// 활성화 상태 필터
		andCriterias.add(Criteria.where("enabled").is(requestDto.isEnable()));

		// 임시 등록 상태 필터
		andCriterias.add(Criteria.where("temporaryEnrolled").is(requestDto.isTemporary()));

		// 커서 기반 페이징
		if (StringUtils.hasText(requestDto.getCursorId())) {
			Document cursorDoc = mongoTemplate.findById(requestDto.getCursorId(), Document.class, "products");
			if (cursorDoc != null) {
				String sortField = getSellersProductSortField(requestDto.getSortOption());
				Object cursorValue = getSellersCursorValue(cursorDoc, requestDto.getSortOption());
				Object createdAt = cursorDoc.get("createdAt");

				boolean isAsc = "ASC".equals(requestDto.getSortBy());

				// 정렬 방향에 따라 비교 연산자 변경
				Criteria cursorCriteria = new Criteria().orOperator(
					new Criteria().andOperator(
						Criteria.where(sortField).is(cursorValue),
						Criteria.where("createdAt").lt(createdAt)
					),
					isAsc ?
						Criteria.where(sortField).gt(cursorValue) :
						Criteria.where(sortField).lt(cursorValue)
				);
				andCriterias.add(cursorCriteria);
			}
		}

		// 모든 조건을 하나의 Criteria로 결합
		Criteria finalCriteria = new Criteria().andOperator(andCriterias.toArray(new Criteria[0]));

		// 정렬 조건 설정
		Sort sort = createSellersProductSort(requestDto.getSortOption(), requestDto.getSortBy());

		Query query = Query.query(finalCriteria)
			.with(sort)
			.limit(pageSize);

		return mongoTemplate.find(query, Product.class);
	}

	private String getSellersProductSortField(String sortOption) {
		if (sortOption == null) {
			return "createdAt";  // 기본값 설정
		}

		switch (sortOption) {
			case "price":
				return "price";
			case "sells":
				return "sells";
			default:
				return "createdAt";
		}
	}

	private Object getSellersCursorValue(Document cursorDoc, String sortOption) {
		if (sortOption == null) {
			return cursorDoc.get("createdAt");  // 기본값 설정
		}

		switch (sortOption) {
			case "price":
				Number price = cursorDoc.get("price", Number.class);
				return price != null ? price.doubleValue() : 0.0;
			case "sells":
				Number sells = cursorDoc.get("sells", Number.class);
				return sells != null ? sells.longValue() : 0L;
			default:
				return cursorDoc.get("createdAt");
		}
	}

	private Sort createSellersProductSort(String sortOption, String sortBy) {
		Sort.Direction direction = "ASC".equals(sortBy) ?
			Sort.Direction.ASC : Sort.Direction.DESC;  // DESC를 기본값으로 설정

		String field = getSellersProductSortField(sortOption);

		return Sort.by(
			Sort.Order.by(field).with(direction),
			Sort.Order.by("_id").with(direction)  // 안정적인 정렬을 위해 _id 추가
		);
	}

	private String getSortField(String sortOption) {
		if (sortOption == null) {
			return "createdAt";  // 기본값 설정
		}

		switch (sortOption) {
			case "like":
				return "likeCount";
			case "avgStar":
				return "avgStar";
			case "sells":
				return "sells";
			case "reviewCount":
				return "reviewCount";
			default:
				return "createdAt";
		}
	}

	private Object getCursorValue(Document cursorDoc, String sortOption) {
		if (sortOption == null) {
			return cursorDoc.get("createdAt");  // 기본값 설정
		}

		switch (sortOption) {
			case "like":
				Number likeCount = cursorDoc.get("likeCount", Number.class);
				return likeCount != null ? likeCount.longValue() : 0L;
			case "avgStar":
				Number avgStar = cursorDoc.get("avgStar", Number.class);
				return avgStar != null ? avgStar.doubleValue() : 0.0;
			case "sells":
				Number sells = cursorDoc.get("sells", Number.class);
				return sells != null ? sells.longValue() : 0L;
			case "reviewCount":
				Number reviewCount = cursorDoc.get("reviewCount", Number.class);
				return reviewCount != null ? reviewCount.longValue() : 0L;
			default:
				return cursorDoc.get("createdAt");
		}
	}

	private Sort createSort(String sortOption, String sortBy) {
		Sort.Direction direction = "DESC".equals(sortBy) ?
			Sort.Direction.DESC : Sort.Direction.ASC;

		String field = getSortField(sortOption);

		return Sort.by(
			Sort.Order.by(field).with(direction),
			Sort.Order.by("_id").with(direction)  // 안정적인 정렬을 위해 _id 추가
		);
	}
}