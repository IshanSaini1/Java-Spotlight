package com.kata.series.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

public class StreamsMain {

	public static void main(String[] args) {

		List<String> bingoPool = new ArrayList<>(75);
		int start = 1;
		for (char c : "BINGO".toCharArray()) {
			for (int i = start; i < (start + 15); i++) {
				bingoPool.add("" + c + i);
				System.out.println("" + c + i);
			}
			start += 15;
		}

		Collections.shuffle(bingoPool);

		System.out.println("------------Bingo Pool START-------------");
		for (int i = 0; i < 15; i++) {
			System.out.print(" " + bingoPool.get(i) + " ");
		}
		System.out.println();
		System.out.println("------------Bingo Pool END-------------");
		System.out.println();
		System.out.println();

		System.out.println("------------Bingo Pool START-------------");
		List<String> firstOnes = bingoPool.subList(0, 15);
		List<String> secondList = new ArrayList<>(firstOnes);
		firstOnes.sort(Comparator.naturalOrder());
		firstOnes.replaceAll(x -> {
			if (x.indexOf('G') == 0 || x.indexOf('O') == 0) {
				String updated = x.charAt(0) + "-" + x.substring(1);
				System.out.print(" " + updated + " ");
				return updated;
			}
			return x;
		});
		System.out.println();
		System.out.println("------------Bingo Pool END-------------");
		System.out.println();
		System.out.println("------------Bingo Pool FIRST ONE START-------------");
		for (int i = 0; i < 15; i++) {
			System.out.print(" " + firstOnes.get(i) + " ");
		}
		System.out.println();
		System.out.println("------------Bingo Pool  FIRST ONE END-------------");
		System.out.println();
		System.out.println("------------Bingo Pool SECOND ONE START-------------");
		for (int i = 0; i < 15; i++) {
			System.out.print(" " + secondList.get(i) + " ");
		}
		System.out.println();
		System.out.println("------------Bingo Pool SECOND ONE END-------------");

		// Using Stream Pipeline

		System.out.println("------------Bingo Pool Via Stream START-------------");
		bingoPool.stream().limit(15).filter(x -> x.indexOf('G') == 0 || x.indexOf('O') == 0)
				.map(x -> x.charAt(0) + "-" + x.substring(1)).sorted(Comparator.naturalOrder())
				.forEach(x -> System.out.print(" " + x + " "));
		System.out.println();
		System.out.println("------------Bingo Pool Via Stream END-------------");
		System.out.println();
		System.out.println("----------------ROUND 2---------------------");
		String[] strings = { "One", "Two", "Three" };
		Arrays.stream(strings).sorted(Comparator.reverseOrder()).forEach(System.out::println);
		System.out.println();
		System.out.println("----------------ROUND 3---------------------");
		Stream.of("Four", "Five", "Six").map(String::toUpperCase).forEach(System.out::println);
		System.out.println();
		System.out.println("----------------ROUND 4------------Combining 2 streams---------");

		Stream<String> s1 = Stream.of("Four", "Five", "Six").map(String::toUpperCase);
		Stream<String> s2 = Arrays.stream(strings).sorted(Comparator.reverseOrder());
		Stream.concat(s1, s2).map(x -> x.charAt(0) + "-" + x).forEach(System.out::println);

		System.out.println("----------------ROUND 5------------Maps---------");
		Map<Character, int[]> myMap = new LinkedHashMap<>();
		int bingoIndex = 1;
		for (char c : "BINGO".toCharArray()) {
			int[] numbers = new int[15];
			int labelNumber = bingoIndex;
			Arrays.setAll(numbers, i -> i + labelNumber);
			myMap.put(c, numbers);
			bingoIndex += 15;
		}

		myMap.entrySet().stream().map(
				e -> e.getKey() + " has Range: " + e.getValue()[0] + " - " + e.getValue()[e.getValue().length - 1] + "")
				.forEach(System.out::println);

		System.out.println("----------------ROUND 6------------Generate---------");
		System.out.println();
		Random rand = new Random();
		Stream.generate(() -> rand.nextInt(2)).limit(10).forEach(x -> System.out.print(" " + x + " "));

	}

}
