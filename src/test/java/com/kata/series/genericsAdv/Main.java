package com.kata.series.genericsAdv;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String args[]) {
		int studentCount = 10;
		List<Student> students = new ArrayList<>();
		for (int i = 0; i < studentCount; i++) {
			students.add(new Student());
		}
		printList(students);

		System.out.println(".........-------------..........");
		List<LPAStudent> lpaStudents = new ArrayList<>();
		for (int i = 0; i < studentCount; i++) {
			lpaStudents.add(new LPAStudent());
		}
		printList(lpaStudents);
	}

	public static void printList(List<? extends Student> studentList) {
		studentList.forEach(x -> System.out.println(x.getYearStarted()+ " ---  " + x.toString()));
	} 
	
	/*
	 * public static <T extends Student> void printList(List<T> studentList) {
	 * studentList.forEach(x -> System.out.println(x.getYearStarted()+ " ---  " +
	 * x.toString())); }
	 */
}
