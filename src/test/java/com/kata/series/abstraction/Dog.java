package com.kata.series.abstraction;

public class Dog extends Animal {

	public Dog(String type, String size, double weight) {
		super(type, size, weight);
	}

	/**
	 *
	 */
	@Override
	public void move(String speed) {
		if (speed.equalsIgnoreCase("Slow")) {
			System.out.println(type + " Walking ");
		} else if (speed.equalsIgnoreCase("Fast")) {
			System.out.println(type + " Running ");
		} else {
			System.out.println(type + " Sitting ");
		}
	}

	/**
	 *
	 */
	@Override
	public void makeNoise() {
		if (type == "Wolf") {
			System.out.println(" Howling !! ");
		} else if (type == "Dog") {
			System.out.println(" Barking !! ");
		} else {
			System.out.println(" Bark ");
		}

	}

}
