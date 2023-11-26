package com.kata.series.collections.sets;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetMain {

	public static void main(String args[]) {
		Set<Integer> one = new HashSet<>();
		Set<Integer> two = new HashSet<>();
		one.addAll(List.of(1, 2, 3, 4, 5));
		two.addAll(List.of(4, 5, 6, 7, 8, 9));
		Set<Integer> unionAll = new HashSet<>();
		printSet(one, "One");
		printSet(two, "Two");
		// Union of Sets
		unionAll.addAll(one);
		unionAll.addAll(two);
		printSet(unionAll, "Union All");
		// Intersection of Sets
		Set<Integer> intersectionSet = new HashSet<>(one);
		intersectionSet.retainAll(two);
		printSet(intersectionSet, " one \u2229 two");
		// Difference in Sets
		one.addAll(List.of(1, 2, 3, 4, 5));
		two.addAll(List.of(4, 5, 6, 7, 8, 9));
		Set<Integer> diffOnetoTwo = new HashSet<>(one);
		diffOnetoTwo.removeAll(two);
		printSet(diffOnetoTwo, "Set Difference One to Two");
		Set<Integer> diffTwotoOne = new HashSet<>(two);
		diffTwotoOne.removeAll(one);
		printSet(diffTwotoOne, "Set Difference One to Two");
	}

	static void printSet(Set<?> set, String setName) {
		System.out.println("-------------" + setName + "-------------");
		set.forEach(x -> System.out.print(" " + x + " "));
		System.out.println();
		System.out.println("-------------------------------------");
	}

}
