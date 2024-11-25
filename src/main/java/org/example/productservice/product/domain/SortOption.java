package org.example.productservice.product.domain;

public enum SortOption {
	LIKE("likeCount", "좋아요순"),
	AVG_STAR("avgStar", "평점순"),
	SELLS("sells", "판매량순"),
	CREATED_AT("createdAt", "최신순");

	private final String field;
	private final String description;

	SortOption(String field, String description) {
		this.field = field;
		this.description = description;
	}

	public String getField() {
		return this.field;
	}
}