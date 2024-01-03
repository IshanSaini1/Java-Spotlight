package com.kata.series.kafka.modules.configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.listener.adapter.RecordFilterStrategy;
import org.springframework.util.backoff.FixedBackOff;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.series.kafka.modules.entity.CarLocation;
import com.kata.series.kafka.modules.error.handler.consumer.GlobalErrorHandler;

@Configuration
public class KafkaConsumerConfig {

	
	@Autowired
	private KafkaProperties kafkaProperties;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Bean()
	public ConsumerFactory<Object, Object> consumerFactory(){
		var properties = kafkaProperties.buildConsumerProperties();
		properties.put(ConsumerConfig.METADATA_MAX_AGE_CONFIG, "120000");
		return new DefaultKafkaConsumerFactory<>(properties);
	}
	
	@Bean(name = "farLocationContainerFactory")
	public ConcurrentKafkaListenerContainerFactory<Object, Object> farLocationContainerFactory(ConcurrentKafkaListenerContainerFactoryConfigurer configurer) {
		var factory = new ConcurrentKafkaListenerContainerFactory<Object,Object>();
		configurer.configure(factory, consumerFactory());
		factory.setRecordFilterStrategy(new RecordFilterStrategy<Object,Object>() {

			@Override
			public boolean filter(ConsumerRecord<Object, Object> consumerRecord) {
				CarLocation carLocation = null;
				try {
					carLocation = objectMapper.readValue(consumerRecord.value().toString(), CarLocation.class);
				} catch (JsonProcessingException e) {
					return false;
				}
				return carLocation.getDistance() > 100;
			}
		
		});
		return factory;
	}
	

	@Bean(name = "kafkaListenerContainerFactory")
	public ConcurrentKafkaListenerContainerFactory<Object, Object> kafkaListenerContainerFactory(ConcurrentKafkaListenerContainerFactoryConfigurer configurer) {
		ConcurrentKafkaListenerContainerFactory< Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
		configurer.configure(factory, consumerFactory());
		factory.setCommonErrorHandler(new GlobalErrorHandler());
		return factory;
	}
	
	@Bean(name = "imageRetryContainerFactory")
	public ConcurrentKafkaListenerContainerFactory<Object, Object> imageRetryContainerFactory(ConcurrentKafkaListenerContainerFactoryConfigurer configurer) {
		ConcurrentKafkaListenerContainerFactory< Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
		configurer.configure(factory, consumerFactory());
		factory.setCommonErrorHandler(new DefaultErrorHandler(new FixedBackOff(10000, 3)));
		return factory;
	}
	
	@Bean(name = "invoiceDltContainerFactory")
	public ConcurrentKafkaListenerContainerFactory<Object, Object> invoiceDeadLettersConnectionFactory(ConcurrentKafkaListenerContainerFactoryConfigurer configurer, KafkaTemplate<String,String> ktemplate) {
		ConcurrentKafkaListenerContainerFactory< Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
		configurer.configure(factory, consumerFactory());
		var recoverer = new DeadLetterPublishingRecoverer(ktemplate, (record, ex)-> new TopicPartition("t-invoice-dead", record.partition()));
		
		factory.setCommonErrorHandler(new DefaultErrorHandler(recoverer, new FixedBackOff(10000, 5)));
		return factory;
	}
	
}
