package com.kata.series.kafka.modules.consumers;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RebalanceConsumer {

	@KafkaListener(topics = { "t-rebalance" }, concurrency = "3")
	public void consumeMessage(ConsumerRecord<String, String> c_record) {
		log.info("Key : {} ; value : {} ; Partition : {} ; Offset : {}", c_record.key(), c_record.value(),c_record.partition(),c_record.offset());
	}
}
