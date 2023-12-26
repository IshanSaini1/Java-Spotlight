package com.kata.series.kafka.modules.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FixedRateConsumer {

	@KafkaListener(topics = "t-fixedrate")
	public void consumeMessageFX1(String message) {
		log.info(" Consuming from t-fixedrate : counter value FX1 : {} ",message);
	}
	
	@KafkaListener(topics = "t-fixedrate-2")
	public void consumeMessageFX2(String message) {
		log.info(" Consuming from t-fixedrate : counter value FX2 :  {} ",message);
	}
	
}
