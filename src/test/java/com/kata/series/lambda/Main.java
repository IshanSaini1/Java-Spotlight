package com.kata.series.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

record Person(String firstName, String lastName) {

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}

public class Main {

	public static void main(String args[]) {
		Person[] arr = { new Person("Ishan", "Saini"), new Person("Kani", "XSD"), new Person("John", "Thompson"),
				new Person("Kaka", "Singer") };
		List<Person> people = new ArrayList<Person>(Arrays.asList(arr));

		Comparator<Person> compareLastName = new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.lastName().compareTo(o2.lastName());
			}
		};
		
		Comparator<Person> compareFirstName =((o1,o2)-> o1.firstName().compareTo(o2.firstName()) );

		people.sort(compareLastName);
		people.sort(compareFirstName);
		System.out.println(people.toString());
	}
}
