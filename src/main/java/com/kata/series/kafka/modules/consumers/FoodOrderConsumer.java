package com.kata.series.kafka.modules.consumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.series.kafka.modules.entity.FoodOrder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FoodOrderConsumer {

	@Autowired
	private ObjectMapper objectMapper;

	private static final int MAX_ORDER_AMOUNT = 7;

	@KafkaListener(topics = "t-food-order", errorHandler = "myFoodOrderErrorHandler")
	public void consume(String message) throws JsonMappingException, JsonProcessingException {
		var foodOrder = objectMapper.readValue(message, FoodOrder.class);
		if (foodOrder.getAmount() > MAX_ORDER_AMOUNT) {
			throw new IllegalArgumentException("Max amount exeeded for item " + foodOrder);
		}
		log.info("Food Order processing : " + foodOrder);
	}

}
