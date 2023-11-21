package com.kata.series.lambda;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

	public static void main(String args[]) {
		List<String> list = new ArrayList<>(List.of("alpha", "bravo", "delta", "charlie"));
		list.sort((o1, o2) -> o1.compareTo(o2));
		list.forEach((x) -> System.out.println(x));
		System.out.println("----------*********---------");
		list.forEach((String s) -> System.out.println(s));
		System.out.println("----------*********---------");
		list.forEach(x -> {
			char c = x.charAt(0);
			System.out.println(c);
		});
		System.out.println("-----------*********-----------");
		Integer i = calculator((v1, v2) -> v1 + v2, 10, 20);
		System.out.println("The Sum is :" + i);
	}

	public static <T> T calculator(Operation<T> function, T value1, T value2) {
		T result = function.operate(value1, value2);
		return result;
	}

}
