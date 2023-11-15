package com.kata.series.covariant;

import org.junit.jupiter.api.Test;

public class CovarientTest {

	void covarientTest() {
		A3 a3 = new A3(1, 2, 3, 4, 5);
		A2 a2 = a3.a2;
		A2 a21 = a3.a21;
		a2.print();
		a21.print();
		a3.print();

		System.out.println(a2 instanceof A3);
		System.out.println(a2 instanceof A2);
		System.out.println(a2 instanceof A1);
		System.out.println(a2 instanceof A3a);

	}

	@Test
	void motaMamba() {
		A1 a1 = new A1(0, 0).motamamba();
		A2 a2 = new A2(0, 0, 0, 0).motamamba();
	}
}
