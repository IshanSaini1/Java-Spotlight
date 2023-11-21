package com.kata.series.lambda2.chaining;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ChainingLambdaMain {

	public static void main(String args[]) {
		String name = "Tim";
		Function<String, String> uCase = String::toUpperCase;
		System.out.println(uCase.apply(name));
		Function<String, String> lastName = s -> s.concat(" Buchalka");
		Function<String, String> functionName = uCase.andThen(lastName).andThen(String::toUpperCase);
		String result1 = functionName.apply(name);
		String result2 = uCase.compose(lastName).apply(name);
		System.out.println(result2);

		record Person(String firstName, String lastName) {

		}

		List<Person> l1 = List.of(new Person("Peter", "Pan"), new Person("Peter", "PumpkinEater"),
				new Person("Mickey", "Mouse"), new Person("Miney", "Mouse"));
		List<Person> personList = new ArrayList<>(l1);

		personList.sort((o1, o2) -> o1.firstName.compareTo(o2.firstName));
		personList.forEach(System.out::println);
		System.out.println("---------------------");
		personList.sort(Comparator.comparing(Person::lastName));
		personList.forEach(System.out::println);
		System.out.println("---------------------");
		personList.sort(Comparator.comparing(Person::lastName).thenComparing(Person::firstName).reversed());
		personList.forEach(System.out::println);

	}

}
