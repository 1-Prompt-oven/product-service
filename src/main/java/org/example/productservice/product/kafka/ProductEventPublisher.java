package org.example.productservice.product.kafka;

import org.example.productservice.product.domain.Product;
import org.example.productservice.product.dto.message.AddProductEventDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductEventPublisher {

	private final KafkaTemplate<String, Object> kafkaTemplate;
	private static final String TOPIC = "product-events";

	public void publishProductCreated(Product product) {
		AddProductEventDto event = AddProductEventDto.toDto(product);
		kafkaTemplate.send(TOPIC, event);
	}

	public void publishProductUpdated(Product product) {
		AddProductEventDto event = AddProductEventDto.toDto(product);
		kafkaTemplate.send(TOPIC, event);
	}

	//TODO: productPolicy, productContent publisher 만들기
}