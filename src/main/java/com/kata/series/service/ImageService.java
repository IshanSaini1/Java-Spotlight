package com.kata.series.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kata.series.kafka.modules.entity.Image;
import com.kata.series.kafka.modules.producers.ImageProducer;

@Service
public class ImageService {
	private static AtomicInteger counter = new AtomicInteger();
	
	@Autowired
	ImageProducer producer;

	public Image generateImage(String type) {
		var name = "image-" + counter.incrementAndGet();
		var size = RandomUtils.nextLong();
		return new Image(name, size, type);
	}
	
	public void sendImage(Image image, Integer partition) throws JsonProcessingException {
		producer.send(image, partition);
	}
}
