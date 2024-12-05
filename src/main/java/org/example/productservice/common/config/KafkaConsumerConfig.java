package org.example.productservice.common.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.example.productservice.product.dto.message.AddAvgRatingMessageDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.fasterxml.jackson.databind.deser.std.StringDeserializer;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

	@Value("${spring.kafka.text-bootstrap-servers}")
	private String bootstrapServers;

	@Bean
	public ConsumerFactory<String, AddAvgRatingMessageDto> consumerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "product-consume-service");

		// ErrorHandlingDeserializer 설정
		configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
		configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);

		// ErrorHandlingDeserializer에 사용할 실제 디시리얼라이저 설정
		configProps.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class.getName());
		configProps.put(ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS, StringDeserializer.class.getName());

		// JsonDeserializer 기본 설정
		configProps.put(JsonDeserializer.VALUE_DEFAULT_TYPE, AddAvgRatingMessageDto.class.getName());
		configProps.put(JsonDeserializer.TRUSTED_PACKAGES, "*");

		return new DefaultKafkaConsumerFactory<>(configProps);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, AddAvgRatingMessageDto> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, AddAvgRatingMessageDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
}