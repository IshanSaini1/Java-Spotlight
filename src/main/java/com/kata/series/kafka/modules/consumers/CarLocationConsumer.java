package com.kata.series.kafka.modules.consumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.series.kafka.modules.entity.CarLocation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CarLocationConsumer {

	@Autowired
	private ObjectMapper objectMapper;

	@KafkaListener(topics = "t-location", groupId = "cg-all-location")
	public void consumeAll(String message) throws JsonMappingException, JsonProcessingException {
		var car = objectMapper.readValue(message, CarLocation.class);
		log.info("CarLocationConsumer - consumeAll - {}", car);
	}

	@KafkaListener(topics = "t-location", groupId = "cg-far-location", containerFactory = "farLocationContainerFactory")
	public void consumeSelective(String message) throws JsonMappingException, JsonProcessingException {
		var car = objectMapper.readValue(message, CarLocation.class);
		log.info("CarLocationConsumer - consumeSelective - Dist>100 - {}", car);
	}

}
