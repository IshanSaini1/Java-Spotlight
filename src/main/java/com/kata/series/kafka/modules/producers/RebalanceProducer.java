package com.kata.series.kafka.modules.producers;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RebalanceProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	private AtomicInteger counter = new AtomicInteger(0);

	public void sendMessage() {
		int count = counter.incrementAndGet();
		kafkaTemplate.send("t-rebalance", "Key-" + count, "Counter-" + count);
	}

}
