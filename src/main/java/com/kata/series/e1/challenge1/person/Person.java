package com.kata.series.e1.challenge1.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.kata.series.e1.challenge1.vehicle.Vehicle;

@Profile("NO_BOOT")
@Component
public class Person {

	private String name = "John";

	@Autowired
	private Vehicle vehicle;

	public String getName() {
		return name;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}
	
	
}
