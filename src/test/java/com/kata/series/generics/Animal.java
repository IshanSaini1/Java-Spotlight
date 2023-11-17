package com.kata.series.generics;

import java.util.List;
import java.util.stream.Stream;

public class Animal<T extends List> {

	private String name;

	@SuppressWarnings("unchecked")
	public void printList(T list) {
		Stream<T> stream = list.stream();
		stream.forEach(x -> System.out.println(x));
	}
}
