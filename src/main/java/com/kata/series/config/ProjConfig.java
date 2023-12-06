package com.kata.series.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.kata.series.e1.Person;
import com.kata.series.e1.Vehicle;

@Profile("NO_BOOT")
@Configuration
@ComponentScan(basePackages = "com.kata.series.e1")
public class ProjConfig {

	@Bean("ferrari")
	Vehicle vehicleFerrari() {
		Vehicle ferrari = new Vehicle();
		ferrari.setName("Ferrari");
		return ferrari;
	}

	/*
	 * @Bean("lucy") Person lucy(Vehicle vehicle) { Person p = new Person();
	 * p.setName("Lucy"); p.setVehicle(vehicle); return p; }
	 */

}
