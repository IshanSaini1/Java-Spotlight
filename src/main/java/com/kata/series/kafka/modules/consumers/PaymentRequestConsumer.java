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
import com.kata.series.kafka.modules.cache.keys.PaymentRequestCacheKeys;
import com.kata.series.kafka.modules.entity.PaymentRequest;
import com.kata.series.kafka.modules.entity.PurchaseRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PaymentRequestConsumer {

	@Autowired
	private ObjectMapper objectMapper;

	@Qualifier("cachePaymentRequest")
	@Autowired
	private Cache<PaymentRequestCacheKeys, Boolean> cache;

	private boolean doesExistInCache(PaymentRequestCacheKeys paymentRequestCacheKeys) {
		return Optional.ofNullable(cache.getIfPresent(paymentRequestCacheKeys)).orElse(false);
	}

	@KafkaListener(topics = "t-payment-request")
	public void consumeMessages(String message) throws JsonMappingException, JsonProcessingException {
		var f = objectMapper.readValue(message, PaymentRequest.class);
		PaymentRequestCacheKeys o = new PaymentRequestCacheKeys(f.getPaymentNumber(), f.getAmount(), f.getTransactionType());
		boolean processed = doesExistInCache(o);
		if (processed) {
			return;
		} else {
			log.info("Processing message {}", f);
			cache.put(o, true);
		}

	}
}
