package org.example.productservice.product.kafka.consumer;

import org.example.productservice.product.application.ProductService;
import org.example.productservice.product.dto.message.AddAvgRatingMessageDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventConsumerByKafka {

	private final ProductService productService;

	@KafkaListener(
		topics = "${aggregate-finish-event}",
		containerFactory = "kafkaListenerContainerFactory"
	)
	@Transactional
	public void consumerCreate(AddAvgRatingMessageDto message) {

		log.info("consumeCreate: {}", message);
		message.getProductAggregateMap().forEach(
			productService::updateAvgRating
		);
	}

}
