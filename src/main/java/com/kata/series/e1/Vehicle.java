package com.kata.series.e1;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Profile("NO_BOOT")
@Component
public class Vehicle {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Vehicle [name=" + name + "]";
	}

	@PreDestroy
	void destroy() {
		System.out.println("Bean is destroyed");
	}

	@PostConstruct
	void construct() {

	}
}
