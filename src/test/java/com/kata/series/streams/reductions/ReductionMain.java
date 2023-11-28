package com.kata.series.streams.reductions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ReductionMain {
	public static void main(String args[]) {
		var result = IntStream.iterate(0, i -> i <= 1000, i -> i + 3).summaryStatistics();
		System.out.println(result);
		System.out.println();
		var leapYear = IntStream.iterate(2000, i -> i <= 2025, i -> i + 1).filter(x -> (x % 4) == 0)
				.peek(x -> System.out.println(x)).summaryStatistics();
		System.out.println(leapYear);
		System.out.println();
		Seat[] seats = new Seat[100];
		Arrays.setAll(seats, i -> new Seat((char) ('A' + i / 10), i % 10 + 1));
		// Arrays.asList(seats).stream().forEach(x -> System.out.printf("%n---%s---%n",
		// x.toString()));

		Long reservedSeats = Arrays.stream(seats).filter(x -> x.isReserved()).count();	
		boolean hasBookings = Arrays.stream(seats).anyMatch(x->x.isReserved());
		
		String reservedResult = "Count : "+reservedSeats+" Has Bookings : "+hasBookings;
		System.out.println(reservedResult);

	}
}
