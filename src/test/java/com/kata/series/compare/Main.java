package com.kata.series.compare;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {

	public static void main(String... args) {
		Integer five = Integer.valueOf(5);
		Integer[] others = { 0, 5, 10, -15, 50 };
		for (Integer o : others) {
			int val = five.compareTo(o);
			System.out.printf(" %d ----- %d  compareTo value = %d %n", five, o, val);
		}
		System.out.println("\n");
		Student s1 = new Student("Tim");
		Student[] otherStudents = { new Student("Zach"), new Student("Tim"), new Student("Ann ") };
		Arrays.sort(otherStudents);
		for (Student o : otherStudents) {
			System.out.println(o.toString());
		}

		Comparator<Student> gpaSorter = new StudentGPAComparator();
		Arrays.sort(otherStudents, gpaSorter.reversed());
		System.out.println("--------------------------");
		for (Student o : otherStudents) {
			System.out.println(o.toString());
		}

		System.out.println();

	}
}

class StudentGPAComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student s2) {
		return (Double.valueOf(o1.gpa)).compareTo(Double.valueOf(s2.gpa));
	}
}

class Student implements Comparable<Student> {
	private static int LAST_ID = 1000;
	private String name;

	private static Random random = new Random();
	private int id;
	protected double gpa;

	public Student(String name) {
		this.name = name;
		id = LAST_ID++;
		gpa = random.nextDouble(1.0, 4.0);
	}

	@Override
	public String toString() {
		return String.format("The Student : %n id : %d  %n name : %s %n gpa : %.2f %n", id, name, gpa);
	}

	@Override
	public int compareTo(Student o) {
		return Integer.valueOf(this.id).compareTo(Integer.valueOf(o.id));
	}

	public String getName() {
		return name;
	}
}
