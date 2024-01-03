package com.kata.series.kafka.modules.consumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.series.kafka.modules.entity.SimpleNumber;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SimpleNumberConsumer {

	@Autowired
	private ObjectMapper objectMapper;

	@KafkaListener(topics = "t-simple-number")
	public void consume(String message) throws JsonMappingException, JsonProcessingException {
		var simpleNumber = objectMapper.readValue(message, SimpleNumber.class);
		if (simpleNumber.getNumber()%2 != 0) {
			throw new IllegalArgumentException("Odd Number " + simpleNumber.getNumber());
		}
		log.info("Simple number is processing : " + simpleNumber);
	}
	
}
