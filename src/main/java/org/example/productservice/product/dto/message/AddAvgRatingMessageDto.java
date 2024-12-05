package org.example.productservice.product.dto.message;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddAvgRatingMessageDto {

	Map<String, Double> productAggregateMap;
}
