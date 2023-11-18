package com.kata.series.lambda2.mains;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerInterfaceTest {

	public static void main(String... args) {

		Consumer<String> c = (x) -> System.out.println(" Message Passed : " + x);
		c.accept("Hello World");

		var coords = new ArrayList<>(List.of(new double[] { 41.23, 65.78 }, new double[] { 61.57, 45.30 },
				new double[] { 11.82, -65.78 }, new double[] { 90.34, -35.33 }));
		BiConsumer<Double, Double> bc1 = (c1, c2) -> System.out
				.println("Latitude = " + c1 + "  " + " Longitude = " + c2);
		coords.forEach(c1 -> bc1.accept(c1[0], c1[1]));

	}
}
