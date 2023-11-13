package com.kata.series.custom;

import org.junit.jupiter.api.Test;

public class EnumTest {

	@Test
	void testEnumDayOfTheWeek() {
		DayOfTheWeek const1 = DayOfTheWeek.MONDAY;
		System.out.println(const1.ordinal());
	}
}
