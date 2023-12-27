package com.kata.series.kafka.modules.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.series.kafka.modules.entity.CarLocation;

@Service
public class CarLocationProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	public void sendMessage(CarLocation carLocation) throws JsonProcessingException {
		String json = objectMapper.writeValueAsString(carLocation);
		kafkaTemplate.send("t-location",json);
	}
	
}
