package com.kata.series.kafka.modules.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.series.kafka.modules.entity.SimpleNumber;

@Service
public class SimpleNumberProducer {

	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private KafkaTemplate<String, String> template;
	
	public void sendSimpleNumber(SimpleNumber number) throws JsonProcessingException {
		var json = mapper.writeValueAsString(number);
		template.send("t-simple-number",json);
	}
}
