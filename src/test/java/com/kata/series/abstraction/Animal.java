package com.kata.series.abstraction;

/**
 * @author Ishan
 *
 */
public abstract class Animal {
	protected String type;
	private String size;
	private double weight;

	public Animal(String type, String size, double weight) {
		super();
		this.type = type;
		this.size = size;
		this.weight = weight;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public abstract void move(String speed);

	public abstract void makeNoise();
}
