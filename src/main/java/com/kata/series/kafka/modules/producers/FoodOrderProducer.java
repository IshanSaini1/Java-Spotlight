package com.kata.series.kafka.modules.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.series.kafka.modules.entity.FoodOrder;

@Service
public class FoodOrderProducer {

	@Autowired
	private KafkaTemplate<String, String> template;

	@Autowired
	private ObjectMapper objectMapper;

	public void send(FoodOrder order) throws JsonProcessingException {
		var json = objectMapper.writeValueAsString(order);
		template.send("t-food-order", json);
	}
}
