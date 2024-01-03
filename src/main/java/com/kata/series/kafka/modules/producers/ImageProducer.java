package com.kata.series.kafka.modules.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.series.kafka.modules.entity.Image;

@Service
public class ImageProducer {

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private KafkaTemplate<String, String> template;

	public void send(Image image, int partition) throws JsonProcessingException {
		var json = mapper.writeValueAsString(image);
		template.send("t-image", partition, image.getType(), json);
	}
}
