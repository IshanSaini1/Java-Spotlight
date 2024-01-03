package com.kata.series.kafka.modules.error.handler.consumer;

import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("myFoodOrderErrorHandler")
public class FoodOrderErrorHandler implements KafkaListenerErrorHandler {

	@Override
	public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
		log.warn("Food order Error, sending message to elastic search : {} ; Exception : {}", message.getPayload(),
				exception.getMessage());
		return null;
	}

}
