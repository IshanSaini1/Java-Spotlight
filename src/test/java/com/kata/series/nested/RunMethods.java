package com.kata.series.nested;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.kata.series.nested.Employee.EmployeeComparator;
import com.kata.series.nested.StoreEmployee.StoreComparator;

public class RunMethods {

	public static void main(String... args) {

		List<StoreEmployee> list1 = new ArrayList<>(List.of(new StoreEmployee(1001, "Ralph", 2015, "Target"),
				new StoreEmployee(1002, "Carole", 2021, "24X7"), new StoreEmployee(1003, "Jane", 2013, "24X7"),
				new StoreEmployee(1004, "Laura", 2020, "Spencers"), new StoreEmployee(1005, "Jim", 2018, "Hari")));

		EmployeeComparator<StoreEmployee> c0 = new Employee.EmployeeComparator<>();
		StoreComparator<StoreEmployee> c1 = new StoreEmployee().new StoreComparator<StoreEmployee>();

		Comparator<StoreEmployee> sortByName = new Comparator<>() {

			@Override
			public int compare(StoreEmployee o1, StoreEmployee o2) {
				int result = o1.name.compareTo(o2.name);
				return result;
			}
		};
		sortIt(list1, c0);
		sortIt(list1, c1);
		sortIt(list1, sortByName);
	}

	public static <T> void sortIt(List<T> list, Comparator<? super T> comparator) {
		System.out.println("Sorting with Comparator : " + comparator.toString());
		list.sort(comparator);
		for (T o : list) {
			System.out.println(o.toString());
		}
	}
}
