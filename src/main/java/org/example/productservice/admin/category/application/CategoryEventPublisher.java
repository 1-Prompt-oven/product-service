package org.example.productservice.admin.category.application;

import org.example.productservice.admin.category.event.CategoryCreatedEvent;
import org.example.productservice.common.domain.Category;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryEventPublisher {
	private final KafkaTemplate<String, Object> kafkaTemplate;
	private static final String TOPIC = "category-events";

	public void publishCategoryCreated(Category category) {
		CategoryCreatedEvent event = CategoryCreatedEvent.from(category);
		kafkaTemplate.send(TOPIC, event);
	}
}