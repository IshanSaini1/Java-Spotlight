package com.kata.series.kafka.modules.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HelloKafkaConsumer {

	@KafkaListener(topics = "t-hello")
	public void consumeMessage(String message) {
		log.info("From Kafka Consumer - t-hello : We got "+message+" .");
	}
}
