package com.kata.series.kafka.modules.consumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.series.kafka.modules.entity.Invoice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InvoiceConsumer {

	@Autowired
	private ObjectMapper objectMapper;

	//@KafkaListener(topics = { "t-invoice" }, concurrency = "2", containerFactory = "invoiceDltContainerFactory")
	public void consume(String message) throws JsonMappingException, JsonProcessingException {
		var invoice = objectMapper.readValue(message, Invoice.class);

		if (invoice.getAmount() < 1) {
			throw new IllegalArgumentException("Invalid Amount : " + invoice.getAmount());
		}

		log.info("Invoice : " + invoice);
	}

}
