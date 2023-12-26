package com.kata.series.kafka.modules.consumers;

import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaKeyConsumer {

	//@KafkaListener(topics = "t-multi-partitions", concurrency = "4")
	public void consume(ConsumerRecord<String, String> consumerRecord) throws Exception {
		log.info("key : {}, partition {}, Message :{} ", consumerRecord.key(), consumerRecord.partition(),
				consumerRecord.value());
		TimeUnit.SECONDS.sleep((long) 0.5);

	}
}
