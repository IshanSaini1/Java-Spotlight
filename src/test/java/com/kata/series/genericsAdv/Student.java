package com.kata.series.genericsAdv;

import java.util.Random;

public class Student {

	 String name;
	 String course;
	 int yearStarted;

	protected static Random random = new Random();

	private static String[] firstNames = { "Ann", "Bob", "Cathy", " John", "Tim" };
	private static String[] courses = { "C++", "Python", "Java" };

	public Student() {
		int lastNameIndex = random.nextInt(65, 91);
		name = firstNames[random.nextInt(0, 5)] + "" + (char) lastNameIndex;
		course = courses[random.nextInt(3)];
		yearStarted = random.nextInt(2018, 2023);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", course=" + course + ", yearStarted=" + yearStarted + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getYearStarted() {
		return yearStarted;
	}

	public void setYearStarted(int yearStarted) {
		this.yearStarted = yearStarted;
	} 
	
}
