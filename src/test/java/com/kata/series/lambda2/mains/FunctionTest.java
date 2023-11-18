package com.kata.series.lambda2.mains;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

public class FunctionTest {

	public static void main(String args[]) {
		String test = "ABC/DEF/GHI/JKL/MNO/PQR";
		String[] strArr = test.split("/");
		System.out.println(strArr.length);

		String[] newStringArr = new String[10];
		Arrays.setAll(newStringArr, (i) -> " " + (i + 1) + ". " + switch (i) {
		case 0 -> "one";
		case 1 -> "two";
		case 2 -> "three";
		case 3 -> "four";
		case 4 -> "five";
		case 5 -> "six";
		case 6 -> "seven";
		case 7 -> "eight";
		case 8 -> "nine";
		case 9 -> "ten";
		default -> throw new IllegalArgumentException("Unexpected value: " + i);
		});
		System.out.println(Arrays.toString(newStringArr));

		String[] names = { "Ann", "Bob", "Carol", "David", "Ed", "Fred" };

		String[] randomList = randomlySelectedValues(15, names, () -> new Random().nextInt(0, names.length));
		System.out.println(Arrays.toString(randomList));
	}

	public static String[] randomlySelectedValues(int count, String[] values, Supplier<Integer> s) {
		String[] selectedValues = new String[count];
		for (int i = 0; i < count; i++) {
			selectedValues[i] = values[s.get()];
		}
		return selectedValues;
	}
}
