package com.kata.series.kafka.modules.producers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FixedRateProducer {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	private AtomicInteger counter = new AtomicInteger();

	//@Scheduled(fixedRate = 3, timeUnit = TimeUnit.SECONDS)
	public void sendMessage() {
		Integer val = counter.incrementAndGet();
		//log.info("Value of fixedRate counter = " + val);
		kafkaTemplate.send("t-fixedrate", "Fixed Rate FX1 = " + val);
		//log.info("Message sent from Fixed rate Producer : " + "Fixed Rate = " + val);
	}
}
