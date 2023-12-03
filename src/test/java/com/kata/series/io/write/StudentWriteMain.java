package com.kata.series.io.write;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentWriteMain {

	private static final String PATH = "./src/test/java/com/kata/series/io/files";
	private static final String FILE_NAME = "/testing1.csv";

	public static void main(String args[]) {
		String header = """
				Student Id,Country Code,Enrolled Year,Age,Gender,\
				Experienced,Course Code, Engagement,Month,Engagement Year,\
				Engagement Type""";
		Course jmc = new Course("JMC", "Java MasterCourse");
		Course pymc = new Course("PYC", "Python MasterCourse");
		List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc)).limit(5)
				.collect(Collectors.toList());
		System.out.println(header);
		students.forEach(t -> t.getEngagementRecords().forEach(System.out::println));

		Path file = Paths.get(getFilePath(PATH, FILE_NAME));
		// writeViaFiles(header, students, file);

		// writeToFileViaBufferedWriter(header, students);

		//write2FileBufferedViaFiles(header, students, file);
		
		try (FileWriter writer = new FileWriter(getFilePath(PATH, FILE_NAME))) {
			writer.write(header);
			for (Student s : students) {
				writer.write(s.getEngagementRecords().toString().concat("\n"));
			}
		} catch (FileNotFoundException i) {
			System.out.print("File Not Found ....");
		} catch (IOException io) {
			System.out.println("Some other IO Exception");
		} finally {
			System.out.println("Buffered Writer call complete");
		}

	}

	private static void write2FileBufferedViaFiles(String header, List<Student> students, Path file) {
		try (BufferedWriter writer = Files.newBufferedWriter(file)) {
			writer.write(header+"\n");
			for (Student s : students) {
				writer.write(s.getEngagementRecords().toString().concat("\n"));
			}
		} catch (FileNotFoundException i) {
			System.out.print("File Not Found ....");
		} catch (IOException io) {
			System.out.println("Some other IO Exception");
		} finally {
			System.out.println("Buffered Writer call complete");
		}
	}

	private static void writeToFileViaBufferedWriter(String header, List<Student> students) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(getFilePath(PATH, FILE_NAME)))) {
			writer.write(header);
			for (Student s : students) {
				writer.write(s.getEngagementRecords().toString().concat("\n"));
			}
		} catch (FileNotFoundException i) {
			System.out.print("File Not Found ....");
		} catch (IOException io) {
			System.out.println("Some other IO Exception");
		} finally {
			System.out.println("Buffered Writer call complete");
		}
	}

	private static void writeViaFiles(String header, List<Student> students, Path file) {
		try {
			Files.writeString(file, header);
			for (Student s : students) {
				Files.write(file, s.getEngagementRecords(), StandardOpenOption.APPEND);
			}
		} catch (FileNotFoundException i) {
			System.out.print("File Not Found ....");
		} catch (IOException io) {
			System.out.println("Some other IO Exception");
		}
	}

	public static String getFilePath(String path, String fileName) {
		return path.concat(fileName);
	}

	public static String getFilePath(String path, String fileName, String extension) {
		return path.concat(fileName).concat(extension);
	}
}
