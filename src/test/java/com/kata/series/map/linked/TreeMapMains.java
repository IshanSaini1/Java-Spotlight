package com.kata.series.map.linked;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TreeMapMains {

	private static Map<String, Purchase> purchases = new LinkedHashMap<>();
	private static NavigableMap<String, Student> students = new TreeMap<>();

	public static void main(String args[]) {
		Course jmc = new Course("jmc101", "Java Master Class", "Java");
		Course python = new Course("pyt101", "Python master Class", "Python");

		addPurchase("Mary Martin", jmc, 129.99);
		addPurchase("Andy Martin", jmc, 139.99);
		addPurchase("Mary Martin", python, 149.99);
		addPurchase("Joe Jones", jmc, 149.99);

		System.out.println("Courses");
		purchases.forEach((k, v) -> System.out.println("key : " + k + " Value : " + v));
		System.out.println("------------------------");
		System.out.println("Students");
		students.forEach((k, v) -> System.out.println("key : " + k + " Value : " + v));

		NavigableMap<LocalDate, List<Purchase>> datedPurchases = new TreeMap<>();
		for (Purchase p : purchases.values()) {
			datedPurchases.compute(p.purchaseDate(), (pdate, plist) -> {
				List<Purchase> list = (plist == null) ? new ArrayList<>() : plist;
				list.add(p);
				return list;
			});
		}
		System.out.println("----------------------");
		datedPurchases.forEach((k, v) -> System.out.println("Key :" + k + " Value : " + v));
		int currentYear = LocalDate.now().getYear();
		LocalDate firstDay = LocalDate.ofYearDay(currentYear, 1);
		LocalDate week1 = firstDay.plusDays(7);
		
		Map<LocalDate, List<Purchase>> weekPurchases = datedPurchases.headMap(week1);
	}

	private static void addPurchase(String name, Course course, double price) {
		Student existingStudent = students.get(name);
		if (existingStudent == null) {
			existingStudent = new Student(name, course);
			students.put(name, existingStudent);
		} else {
			existingStudent.addCourse(course);
		}

		int day = purchases.size() + 1;
		String key = course.courseId() + "_" + existingStudent.getId();
		int year = LocalDate.now().getYear();
		Purchase purchase = new Purchase(course.courseId(), existingStudent.getId(), price, year, day);
		purchases.put(key, purchase);
	}
}
