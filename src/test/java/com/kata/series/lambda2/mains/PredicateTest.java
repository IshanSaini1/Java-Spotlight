package com.kata.series.lambda2.mains;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String args[]) {
		Predicate<String> filter1 = (x) -> x.contains("123");
		boolean b1 = filter1.test("Ishan Saini");
		boolean b2 = filter1.test("12345678910");
		boolean b3 = filter1.test("Ishan123456Saini");
		boolean[] boolArr = new boolean[] { b1, b2, b3 };
		System.out.println(boolArr[0]);
		System.out.println(boolArr[1]);
		System.out.println(boolArr[2]);

		var coords = new ArrayList<>(List.of(new double[] { 41.23, 65.78 }, new double[] { 61.57, 45.30 },
				new double[] { 11.82, -65.78 }, new double[] { 90.34, -35.33 }));
		System.out.println(coords.size());
		coords.removeIf(x -> (x[0] < 0 || x[1] < 0));
		System.out.println(coords.size());
	}

}
