package com.kata.series.kafka.modules.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kata.series.kafka.modules.entity.CarLocation;
import com.kata.series.kafka.modules.producers.CarLocationProducer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CarLocationScheduler {

	private CarLocation carOne;
	private CarLocation carTwo;
	private CarLocation carThree;

	@Autowired
	private CarLocationProducer producer;

	public CarLocationScheduler() {
		var now = System.currentTimeMillis();
		carOne = new CarLocation("car-one", now, 0);
		carTwo = new CarLocation("car-two", now, 110);
		carThree = new CarLocation("car-three", now, 95);
	}

	//@Scheduled(fixedRate = 10000)
	public void generateCarLocation() throws JsonProcessingException {
		var now = System.currentTimeMillis();

		carOne.setTimestamp(now);
		carTwo.setTimestamp(now);
		carThree.setTimestamp(now);

		carOne.setDistance(carOne.getDistance() + 1);
		carTwo.setDistance(carTwo.getDistance() - 1);
		carThree.setDistance(carThree.getDistance() + 1);

		producer.sendMessage(carOne);
		producer.sendMessage(carTwo);
		producer.sendMessage(carThree);

		log.info(" SEND TO KAFKA : {} ", carOne);
		log.info(" SEND TO KAFKA : {} ", carTwo);
		log.info(" SEND TO KAFKA : {} ", carThree);
	}
}
