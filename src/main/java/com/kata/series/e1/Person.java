package com.kata.series.e1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {

	private String name = "Lucy";

	// @Autowired
	private Vehicle vehicle;

	public Person(@Qualifier("ferrari") Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", vehicle=" + vehicle + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	// @Autowired
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
