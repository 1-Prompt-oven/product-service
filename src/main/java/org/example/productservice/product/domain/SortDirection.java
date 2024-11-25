package org.example.productservice.product.domain;

public enum SortDirection {
	ASC("ASC", "오름차순"),
	DESC("DESC", "내림차순");

	private final String value;
	private final String description;

	SortDirection(String value, String description) {
		this.value = value;
		this.description = description;
	}

	public String getValue() {
		return this.value;
	}
}