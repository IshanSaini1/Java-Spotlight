package com.kata.series.challenges;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArraysTest {

	private final static Random random = new Random();

	public static void main(String[] args) {
		Integer[] arr1 = generateIntergerArray().get();
		printArray(arr1);
		Integer[] arr2 = generateIntergerArray().get();
		printArray(arr2);

		Stream<Integer> a1 = Arrays.stream(arr1);
		Stream<Integer> a2 = Arrays.stream(arr2);
		List<Integer> l1 = Stream.concat(a1, a2).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
		Double median = getIndex(l1);
		System.out.println("\n Final Array : ");
		l1.forEach(t -> System.out.print(" " + t + " "));
		System.out.println();
		System.out.println("\n Median " + median);

	}

	public static Double getIndex(List<Integer> list) {
		int length = list.size();
		int mid = length / 2;
		if (length % 2 == 0) {
			return Double.valueOf((list.get(mid) + list.get(mid + 1)) / 2);
		} else {
			return Double.valueOf(list.get(mid));
		}
	}

	public static Supplier<Integer[]> generateIntergerArray() {
		int lengthOfArray = random.nextInt(1, 11);
		Integer array[] = new Integer[lengthOfArray];
		for (int i = 0; i < lengthOfArray; i++) {
			array[i] = random.nextInt(-60, 500);
		}
		return () -> array;
	}

	public static void printArray(Integer[] array) {
		System.out.println();
		System.out.println("Prtinting Array ......\n");
		Consumer<Integer[]> arrayConsume = (t) -> Arrays.stream(t).forEach(i -> System.out.printf(" %d ", i));
		arrayConsume.accept(array);
		System.out.println();
	}

}
