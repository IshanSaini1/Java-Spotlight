package com.kata.series.kafka.modules.consumers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.benmanes.caffeine.cache.Cache;
import com.kata.series.kafka.modules.entity.PurchaseRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PurchaseRequestConsumer {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	@Qualifier("cachePurchaseRequest")
	private Cache<Integer, Boolean> cache;

	private boolean doesExistInCache(Integer purchaseReqeustId) {
		return Optional.ofNullable(cache.getIfPresent(purchaseReqeustId)).orElse(false);
	}

	@KafkaListener(topics = "t-purchase-request")
	public void consumeMessage(String message) throws JsonMappingException, JsonProcessingException {
		var purchaseRequest = objectMapper.readValue(message, PurchaseRequest.class);
		boolean processed = doesExistInCache(purchaseRequest.getId());
		if (processed) {
			return;
		} else {
			log.info("Processing message {}", purchaseRequest);
			cache.put(purchaseRequest.getId(), true);
		}

	}
}
