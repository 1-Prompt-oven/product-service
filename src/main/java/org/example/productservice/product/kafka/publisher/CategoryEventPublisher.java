package org.example.productservice.product.kafka.publisher;

import org.example.productservice.category.domain.Category;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryEventPublisher {
	private final KafkaTemplate<String, Object> kafkaTemplate;
	private static final String TOPIC = "category-events";

	public void publishCategoryCreated(Category category) {
		AddCategoryEventDto event = AddCategoryEventDto.toDto(category);
		kafkaTemplate.send(TOPIC, event);
	}
}