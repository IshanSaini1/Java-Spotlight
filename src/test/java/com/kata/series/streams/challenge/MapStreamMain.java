package com.kata.series.streams.challenge;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kata.series.streams.challenge.Student.Courses;

public class MapStreamMain {

	public static void main(String[] args) {
		var students = StudentHelper.getStudentData(10);
		students.forEach(System.out::println);

		System.out.println();
		System.out.println();

		Map<Courses, List<Student>> mappedStudents = students.stream()
				.collect(Collectors.groupingBy(Student::getCourse));
		mappedStudents
				.forEach((t, u) -> System.out.println("Key : " + t + " Number of Entries with Key : " + u.size()));

		// Flat Map : From Map to Stream.
		Integer sumOfValues = mappedStudents.values().stream().mapToInt(l -> l.size()).sum();
		System.out.println(sumOfValues);

		Long count = mappedStudents.values().stream().flatMap(t -> t.stream())
				.filter(x -> x.getGpa().compareTo(BigDecimal.valueOf(70)) > 0).peek(System.out::println).count();
		System.out.println("Count :" + count);

	}

}
