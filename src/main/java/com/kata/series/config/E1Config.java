package com.kata.series.config;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.kata.series.e1.Vehicle;

@Configuration
public class E1Config {

	@Bean
	Vehicle vehicle1() {
		Vehicle audi = new Vehicle();
		audi.setName("Audi");
		return audi;
	}

	@Primary
	@Bean()
	Vehicle vehicle2() {
		Vehicle audi = new Vehicle();
		audi.setName("Mercedes");
		return audi;
	}

	@Bean
	Vehicle vehicle3() {
		Vehicle audi = new Vehicle();
		audi.setName("Skoda");
		return audi;
	}

	@Bean
	String hello() {
		return "Hello Bean";
	}

	@Bean
	Integer number() {
		return Integer.valueOf(16);
	}
	
	@Bean
	Random random() {
		return new Random();
	}

}
