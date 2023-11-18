package com.kata.series.nested;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String... args) {
		List<Employee> list = new ArrayList<>(List.of(new Employee(1001, "Ralph", 2015),
				new Employee(1002, "Carole", 2021), new Employee(1003, "Jane", 2013), new Employee(1004, "Laura", 2020),
				new Employee(1005, "Jim", 2018)));

		list.sort(new Employee.EmployeeComparator<Employee>("id").reversed());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("--------***********---------");
		List<StoreEmployee> list1 = new ArrayList<>(List.of(new StoreEmployee(1001, "Ralph", 2015, "Target"),
				new StoreEmployee(1002, "Carole", 2021, "24X7"), new StoreEmployee(1003, "Jane", 2013, "24X7"),
				new StoreEmployee(1004, "Laura", 2020, "Spencers"), new StoreEmployee(1005, "Jim", 2018, "Hari")));
		var generalEmployee = new StoreEmployee();
		Comparator<StoreEmployee> c = generalEmployee.new StoreComparator<StoreEmployee>();
		list1.sort(c);
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}

	}

}
