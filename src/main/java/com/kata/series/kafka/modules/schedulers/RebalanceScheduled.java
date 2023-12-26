package com.kata.series.kafka.modules.schedulers;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kata.series.kafka.modules.producers.RebalanceProducer;

@Component
public class RebalanceScheduled {

	@Autowired
	private RebalanceProducer producer;

	@Scheduled(fixedRate = 2, timeUnit = TimeUnit.SECONDS)
	public void triggerProducer() {
		producer.sendMessage();
	}

}
