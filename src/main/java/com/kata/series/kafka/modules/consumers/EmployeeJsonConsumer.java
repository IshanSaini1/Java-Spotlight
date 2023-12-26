package com.kata.series.kafka.modules.consumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.series.kafka.modules.entity.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeJsonConsumer {

	@Autowired
	private ObjectMapper objectMapper;

	@KafkaListener(topics = { "t-employee" })
	public void consumeMessage(String message) throws JsonMappingException, JsonProcessingException {
		Employee emp = objectMapper.readValue(message, Employee.class);
		log.info("Consumer for t-employee recieved : " + emp);
	}
}
