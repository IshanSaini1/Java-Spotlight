package com.kata.series.map.adventure;

import java.util.HashMap;
import java.util.Map;

import com.kata.series.map.adventure.Locations.DIRECTION;

public class AdventureInitializer {

	public static Locations setDefaultDataAndReturnStartingPoint() {

		// Init directional arrays
		Map<DIRECTION, Locations> roadLocations = new HashMap<>();
		Map<DIRECTION, Locations> forestLocations = new HashMap<>();
		Map<DIRECTION, Locations> lakeLocations = new HashMap<>();
		Map<DIRECTION, Locations> wellHouseLocations = new HashMap<>();
		Map<DIRECTION, Locations> streamLocations = new HashMap<>();
		Map<DIRECTION, Locations> valleyLocations = new HashMap<>();
		Map<DIRECTION, Locations> hillLocations = new HashMap<>();

		// init data objects
		Locations roadData = new Locations("Road", "This is the Starting point", roadLocations);
		Locations forestData = new Locations("forest", "This is the Forest", forestLocations);
		Locations lakeData = new Locations("Lake", "This is the Lake", lakeLocations);
		Locations wellHouseData = new Locations("Well House", "This is the Well house", wellHouseLocations);
		Locations streamData = new Locations("Stream", "This is the Stream", streamLocations);
		Locations valleyData = new Locations("Valley", "This is the Valley", valleyLocations);
		Locations hillData = new Locations("Hills", "This is the Hills", hillLocations);

		// fill the directions

		roadLocations.put(DIRECTION.N, forestData);
		roadLocations.put(DIRECTION.S, valleyData);
		roadLocations.put(DIRECTION.E, wellHouseData);
		roadLocations.put(DIRECTION.W, hillData);

		forestLocations.put(DIRECTION.N, forestData);
		forestLocations.put(DIRECTION.S, roadData);
		forestLocations.put(DIRECTION.E, lakeData);
		forestLocations.put(DIRECTION.W, forestData);

		lakeLocations.put(DIRECTION.N, lakeData);
		lakeLocations.put(DIRECTION.S, wellHouseData);
		lakeLocations.put(DIRECTION.E, lakeData);
		lakeLocations.put(DIRECTION.W, forestData);

		wellHouseLocations.put(DIRECTION.N, lakeData);
		wellHouseLocations.put(DIRECTION.S, streamData);
		wellHouseLocations.put(DIRECTION.E, wellHouseData);
		wellHouseLocations.put(DIRECTION.W, roadData);

		streamLocations.put(DIRECTION.N, wellHouseData);
		streamLocations.put(DIRECTION.S, streamData);
		streamLocations.put(DIRECTION.E, streamData);
		streamLocations.put(DIRECTION.W, valleyData);

		valleyLocations.put(DIRECTION.N, roadData);
		valleyLocations.put(DIRECTION.S, valleyData);
		valleyLocations.put(DIRECTION.E, streamData);
		valleyLocations.put(DIRECTION.W, hillData);

		hillLocations.put(DIRECTION.N, forestData);
		hillLocations.put(DIRECTION.S, hillData);
		hillLocations.put(DIRECTION.E, roadData);
		hillLocations.put(DIRECTION.W, hillData);
		
		return roadData;
	}
}
