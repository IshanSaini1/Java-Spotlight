package com.kata.series.streams.challenge;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kata.series.streams.challenge.Student.Courses;

public class StudentHelper {

	public static List<Student> getStudentData(int limit) {
		Random rand = new Random();
		List<Student> returnableList = new ArrayList<>();
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < limit; i++) {
			int l1 = rand.nextInt(13);
			int l2 = rand.nextInt(14, 25);
			String genName = letters.substring(l1, l2);
			genName = ((genName).length() <= 3) ? genName : genName.substring(0, 3);
			BigDecimal randomGPA = BigDecimal.valueOf(rand.nextDouble(10.0, 100.0));
			returnableList.add(new Student(genName, randomGPA, Courses.returnValue(rand.nextInt(0, 2))));
		}

		return returnableList;

	}

	public static List<Student> getStudentData() {
		return getStudentData(20);

	}
}
