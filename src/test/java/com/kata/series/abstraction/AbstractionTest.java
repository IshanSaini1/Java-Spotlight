package com.kata.series.abstraction;

import org.junit.jupiter.api.Test;

public class AbstractionTest {

	@Test
	public void AbstractionTests() {
		Dog d1 = new Dog("Wolf", "Big", 100);
		baseMethod(d1, "Slow");
	}

	private void baseMethod(Animal animal, String speed) {
		animal.makeNoise();
		animal.move(speed);
	}

}
