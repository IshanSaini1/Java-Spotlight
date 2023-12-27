package com.kata.series.kafka.modules.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.series.kafka.modules.entity.PurchaseRequest;

@Service
public class PurchaseRequestProducer {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(PurchaseRequest purchaseRequest) throws JsonProcessingException {
		String json = objectMapper.writeValueAsString(purchaseRequest);
		kafkaTemplate.send("t-purchase-request", purchaseRequest.getPrNumber(), json);
	}
}
