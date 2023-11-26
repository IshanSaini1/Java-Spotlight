package com.kata.series.map.adventure;

import java.util.Scanner;

import com.kata.series.map.adventure.Locations.DIRECTION;

public class AdventureMain {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Locations road = AdventureInitializer.setDefaultDataAndReturnStartingPoint();
		Locations currentLocation = road;
		while (true) {
			System.out.println("You are at : " + currentLocation.getName());
			System.out.println("Please provide a direction to go to N,S,E,W ?");
			String nextDirection = sc.next();
			DIRECTION nextDEnumValue;
			switch (nextDirection) {
			case "W":
			case "w":
				nextDEnumValue = DIRECTION.W;
				break;
			case "N":
			case "n":
				nextDEnumValue = DIRECTION.N;
				break;
			case "E":
			case "e":
				nextDEnumValue = DIRECTION.E;
				break;
			case "S":
			case "s":
				nextDEnumValue = DIRECTION.S;
				break;
			default:
				continue;
			}
			;
			Locations newLocation = currentLocation.getNextLocations().get(nextDEnumValue);
			if (newLocation.equals(currentLocation)) {
				System.out.println("You are at the same location : " + newLocation.getName());
			}
			currentLocation = newLocation;
			
			System.out.println("Do you want to exit ??\n then write yes");
			if (sc.next().equalsIgnoreCase("yes")) {
				System.exit(0);
			}
		}
	}
}
