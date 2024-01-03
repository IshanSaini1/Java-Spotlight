package com.kata.series.kafka.modules.error.handler.consumer;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.CommonErrorHandler;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GlobalErrorHandler implements CommonErrorHandler {

	  @Override
	  public void handleRecord(
	      Exception thrownException,
	      ConsumerRecord<?, ?> record,
	      Consumer<?, ?> consumer,
	      MessageListenerContainer container) {
	    log.warn("Global error handler for message: {}; Exception message : {}", record.value().toString(), thrownException.getMessage());
	  }
	  
	  
	  
	}