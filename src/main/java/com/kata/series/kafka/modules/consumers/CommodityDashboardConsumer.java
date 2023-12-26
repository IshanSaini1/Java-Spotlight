package com.kata.series.kafka.modules.consumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.series.kafka.modules.entity.Commodity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommodityDashboardConsumer {

	@Autowired
	private ObjectMapper objectMapper;
	
	
	@KafkaListener(topics = {"t-commodity"}, groupId = "cg-dashboard")
	public void consumeMessage(String message) throws JsonMappingException, JsonProcessingException {
		var commodity = objectMapper.readValue(message, Commodity.class);
		log.info("Dashboard Logic for : {}", commodity.toString());
	}
	
}
