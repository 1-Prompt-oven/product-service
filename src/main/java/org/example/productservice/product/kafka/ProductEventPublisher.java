package org.example.productservice.product.kafka;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductEventPublisher {

	// private final KafkaTemplate<String, Object> kafkaTemplate;
	// private static final String TOPIC = "product-events";
	//
	// public void publishProductCreated(Product product) {
	// 	AddProductEventDto event = AddProductEventDto.toDto(product);
	// 	kafkaTemplate.send(TOPIC, event);
	// }
	//
	// public void publishProductUpdated(Product product) {
	// 	AddProductEventDto event = AddProductEventDto.toDto(product);
	// 	kafkaTemplate.send(TOPIC, event);
	// }
	//
	// public void publishProductDeleted(Product product) {
	// 	AddProductEventDto event = AddProductEventDto.toDto(product);
	// 	kafkaTemplate.send(TOPIC, event);
	// }
	//
	// // 어차피 RDB에 저장한 객체 자체를 보내는 것이라면 CRD에 따라 메소드를 나눌 필요가 있을까? 하나로 통합해도 되지 않을까?
	//
	// // topic과 group id를 나누는 명확한 기준이 뭘까?
	//
	// private void handleCallback(CompletableFuture<SendResult<String, Object>> future, EventType eventType) {
	// 	future
	// 		// 메시지 전송 성공 시 실행되는 로직
	// 		.thenAccept(result ->
	// 			log.debug("Product {} event published successfully [topic: {}, partition: {}, offset: {}]",
	// 				eventType,                                    // 어떤 이벤트인지 (created/updated/deleted)
	// 				result.getRecordMetadata().topic(),          // 메시지가 전송된 토픽
	// 				result.getRecordMetadata().partition(),      // 메시지가 저장된 파티션 번호
	// 				result.getRecordMetadata().offset())         // 메시지의 오프셋 위치
	// 		)
	// 		.exceptionally(ex -> {
	// 			log.error("Failed to publish product {} event", eventType.toString(), ex);
	// 			return null;
	// 		});
	// }
	//
	// public void publishProductCreated(Product product) {
	// 	ProductEventDto event = ProductEventDto.toDto(product);
	// 	log.info("Publishing product created event: {}", event);
	// 	handleCallback(kafkaTemplate.send(TOPIC, event), EventType.CREATED);
	// }
	//
	// public void publishProductUpdated(Product product) {
	// 	ProductEventDto event = ProductEventDto.toDto(product);
	// 	log.info("Publishing product updated event: {}", event);
	// 	handleCallback(kafkaTemplate.send(TOPIC, event), EventType.UPDATED);
	// }
	//
	//
	// // 아래처럼 DTO에 객체 자체를 넘겨주는 방식은 권장되지 않는건가?
	// // DTO 구성 요소에 넘겨줄 객체, 이벤트 타입, 시간을 담아서 보내는 방식을 활용하려고 했다.
	// //public void publishProductUpdated(Product product) {
	// //         ProductEventDto event = ProductEventDto.builder()
	// //             .product(product)
	// //             .eventType(ProductEventType.UPDATED)
	// //             .timestamp(LocalDateTime.now())
	// //             .build();
	// //
	// //         log.info("Publishing product updated event: {}", event);
	// //         handleCallback(kafkaTemplate.send(TOPIC, event), ProductEventType.UPDATED);
	// //     }
	//
	//
	//
	// //TODO: productPolicy, productContent publisher 만들기
}