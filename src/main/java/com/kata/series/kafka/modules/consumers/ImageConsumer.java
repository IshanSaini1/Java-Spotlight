package com.kata.series.kafka.modules.consumers;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.series.kafka.modules.entity.Image;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ImageConsumer {

	@Autowired
	private ObjectMapper objectMapper;

	@KafkaListener(topics = "t-image", containerFactory = "imageRetryContainerFactory", concurrency = "2")
	public void consume(ConsumerRecord<String, String> record) throws JsonMappingException, JsonProcessingException {
		var image = objectMapper.readValue(record.value(), Image.class);

		if (image.getType().equalsIgnoreCase("svg")) {
			log.warn("Throwing Exception for image {} on partition {}", image, record.partition());
			throw new IllegalArgumentException("Simulation API failed");
		}
		log.info("processing on partition {} for image {}", record.partition(), image);
	}
}
