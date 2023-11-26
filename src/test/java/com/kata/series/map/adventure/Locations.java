package com.kata.series.map.adventure;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Locations {

	private String name;
	private String description;
	private Map<DIRECTION, Locations> nextLocations = new HashMap<>();

	public static enum DIRECTION {
		N,S,E,W;
	}
}
