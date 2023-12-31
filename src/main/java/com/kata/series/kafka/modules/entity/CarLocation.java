package com.kata.series.kafka.modules.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarLocation {

	private String carId;
	private long timestamp;
	private int distance;

}
