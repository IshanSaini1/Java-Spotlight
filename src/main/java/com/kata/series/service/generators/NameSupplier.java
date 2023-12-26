package com.kata.series.service.generators;

import java.util.function.Supplier;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class NameSupplier implements Supplier<String> {

	@Override
	public String get() {
		String name = RandomStringUtils.randomAlphabetic(5);
		return name;
	}
}
