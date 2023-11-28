package com.kata.series.streams.challenge;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NewMain {

	public static void main(String args[]) {
		List<Student> dataList1 = StudentHelper.getStudentData(10);
		List<Student> dataList2 = StudentHelper.getStudentData(10);

		var st1 = dataList1.stream().filter(NewMain::filterGPA).count();
		var st2 = dataList2.stream().filter(NewMain::filterGPA).count();
		var st3 = Stream
				.concat(dataList1.stream().filter(NewMain::filterGPA), dataList2.stream().filter(NewMain::filterGPA))
				.count();
		System.out.println("Count \n Stream 1 : " + st1 + " Stream 2 : " + st2 + " Stream Combined : " + st3);
		List<Student> stuList = Stream
				.concat(dataList1.stream().filter(NewMain::filterGPA), dataList2.stream().filter(NewMain::filterGPA))
				.toList();

		List<Student> stuList1 = Stream
				.concat(dataList1.stream().filter(NewMain::filterGPA), dataList2.stream().filter(NewMain::filterGPA))
				.collect(Collectors.toList());

		stuList.forEach(System.out::println);

		System.out.println("Printing the Tree");
		TreeSet<Student> treeOfStudent = dataList1.stream().filter(NewMain::filterGPA).collect(
				() -> new TreeSet<>(Comparator.comparing(Student::getGpa).reversed()), TreeSet::add, TreeSet::addAll);
		treeOfStudent.forEach(System.out::println);

		OptionalInt intOpt = IntStream.rangeClosed(1, 100).reduce((left, right) -> left + right);
		System.out.println(intOpt.getAsInt() + "  " + intOpt.isPresent());
		Optional.ofNullable(null).ifPresentOrElse(t -> System.out.println(" We Got " + t),
				() -> System.out.println("The mentioned String value is not found or is empty"));

		System.out.println("New Start");
		var adding = Optional.of(dataList1).stream()
				.collect(() -> new ArrayList<Student>(), ArrayList::addAll, (t, u) -> t.addAll(u)).stream()
				.map(s -> s.getGpa()).reduce(BigDecimal::add);
		adding.ifPresent(System.out::println);
		
		

	}

	private static boolean filterGPA(Student s) {
		boolean result = (s.getGpa().compareTo(BigDecimal.valueOf(80)) > 0) ? true : false;
		return result;
	}
}
