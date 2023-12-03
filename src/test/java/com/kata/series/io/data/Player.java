package com.kata.series.io.data;

import java.io.Serializable;
import java.util.List;

public class Player implements Serializable {

	private String name;
	private int topScore;
	private List<String> collectedWeapons;

	public Player(String name, int topScore, List<String> collectedWeapons) {
		super();
		this.name = name;
		this.topScore = topScore;
		this.collectedWeapons = collectedWeapons;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", topScore=" + topScore + ", collectedWeapons=" + collectedWeapons + "]";
	}

}