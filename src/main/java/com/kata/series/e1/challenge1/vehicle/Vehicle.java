package com.kata.series.e1.challenge1.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("NO_BOOT")
@Component
public class Vehicle {
	
	@Autowired
	private VehicleService vehicleService;

	public VehicleService getVehicleService() {
		return vehicleService;
	}
	
	
}
