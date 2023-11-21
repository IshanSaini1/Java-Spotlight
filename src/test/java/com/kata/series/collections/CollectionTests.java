package com.kata.series.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

public class CollectionTests {

	public static void main(String a[]) {
		Collection<String> list = new TreeSet<>();
		String[] names = { "Anna", "Bob", "Carol", "David", "Edna" };
		list.addAll(Arrays.asList(names));
		System.out.println(list.contains("Anna"));
		list.removeIf(x -> x.startsWith("A"));
		System.out.println(list.contains("Anna"));
		System.out.println(list);
	}
}
