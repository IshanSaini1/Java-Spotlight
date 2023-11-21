package com.kata.series.lambda2.references;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.kata.series.lambda2.OperationService;

public class MethodRefMain {

	public static void main(String args[]) {
		List<String> listOfNames = new ArrayList<>(List.of("Anna", "Brian", "Courtney", "David", "Erasmus", "Finn"));
		listOfNames = listOfNames.stream().map(String::toUpperCase).collect(Collectors.toList());
		listOfNames.forEach(System.out::println);
		var one = OperationService.calculator(String::concat, "Hello ", "World");
		System.out.println(one);

		BiFunction<String, String, Integer> biFunc = (x, y) -> Integer.valueOf(4);
		System.out.println(biFunc.apply("Hello", "World"));
		Function<Integer, String> simpFunc = (x) -> "Hello ".concat(x.toString());
		System.out.println(simpFunc.apply(10));
	}
}
