package com.kata.series.kafka.modules.schedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kata.series.kafka.modules.entity.Commodity;
import com.kata.series.kafka.modules.producers.CommodityProducer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommodityScheduler {

	@Autowired
	private Environment env;
	
	private final String HOST_NAME = "http://127.0.0.1:";

	@Autowired
	private CommodityProducer commodityProducer;

	@Autowired
	private RestTemplate restTemplate;

	//@Scheduled(timeUnit = TimeUnit.SECONDS, fixedRate = 5)
	public void retrieveCommodity() {
		String port = env.getProperty("server.port");
		var call = restTemplate.exchange(HOST_NAME+port+ "/kafka/commodity", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Commodity>>() {
				});
		call.getBody().forEach(t -> {
			try {
				log.info("Sending : " + t);
				commodityProducer.send(t);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		});
		log.info("Messages have been sent to kafka");
	}
}
