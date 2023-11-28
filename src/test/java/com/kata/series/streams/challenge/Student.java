package com.kata.series.streams.challenge;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Student {

	private static int count = 0;

	private String name;
	private BigDecimal gpa;
	private int rollNumber;
	private Courses course;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getGpa() {
		return gpa;
	}

	public void setGpa(BigDecimal gpa) {
		this.gpa = gpa.setScale(2, RoundingMode.HALF_UP);
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public Student(String name, BigDecimal gpa, Courses course) {
		count = count + 1;
		rollNumber = count;
		this.name = name;
		this.gpa = gpa.setScale(2, RoundingMode.HALF_UP);
		this.course = course;

	}

	public Courses getCourse() {
		return course;
	}

	@Override
	public String toString() {
		return "Student " + "[Roll Number " + rollNumber + " name=" + name + ", gpa=" + gpa + " Courses : " + course
				+ "]";
	}

	public enum Courses {

		C1("Courses 1", 0), C2("Courses 2", 1);

		private String description;
		private Integer value;

		Courses(String description, Integer value) {
			this.description = description;
			this.value = value;
		}

		public String getDescription() {
			return this.description;
		}

		public static Courses returnValue(int value) {
			for (Courses c : Courses.values()) {
				if (c.value == value) {
					return c;
				}
			}
			return C1;

		}

		@Deprecated
		public Courses returnValueOld(int value) {
			switch (value) {
			case 0:
				return C1;
			case 1:
				return C2;
			default:
				return C1;
			}
		}
	}

}
