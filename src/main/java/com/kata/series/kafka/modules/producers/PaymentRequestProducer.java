package com.kata.series.kafka.modules.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.series.kafka.modules.entity.PaymentRequest;

@Service
public class PaymentRequestProducer {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(PaymentRequest paymentRequest) throws JsonProcessingException {
		String json = objectMapper.writeValueAsString(paymentRequest);
		kafkaTemplate.send("t-payment-request", paymentRequest.getPaymentNumber(), json);
	}
}
