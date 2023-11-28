package com.kata.series.streams;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamsMain2 {
	public static void main(String... arg) {
		/*
		 * IntStream .iterate('A', i -> i <= (int) 'z', i -> i + 1)
		 * .filter(Character::isAlphabetic) .map(Character::toUpperCase) //.distinct()
		 * //.takeWhile(i -> i <= 'E') // .skip(5) .forEach(d ->
		 * System.out.printf(" %c ", d));
		 */
		/*
		 * Random random = new Random(); Stream.generate(() ->
		 * random.nextInt(Integer.valueOf('A'), Integer.valueOf('Z' +
		 * 1))).limit(50).distinct() .sorted().forEach(d -> System.out.printf(" %n %c ",
		 * d));
		 */

		System.out.println();
		int maxSeats = 100;
		int seatsInRows = 10;
		var stream = Stream.iterate(0, i -> i < maxSeats, i -> i + 1)
				.map(i -> new Seat((char) ('A' + i / seatsInRows), i % seatsInRows + 1)).skip(5).limit(10)
				.peek(s -> System.out.println("-->  " + s))
				.sorted(Comparator.comparing(Seat::price).thenComparing(Seat::seatNumber).reversed());
		/*
		 * .mapToDouble(Seat::price) .boxed() .map("%.2f"::formatted);
		 */
		stream.forEach(System.out::println);

	}
}
