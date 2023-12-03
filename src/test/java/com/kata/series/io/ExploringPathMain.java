package com.kata.series.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.util.Map;

public class ExploringPathMain {

	public static void main(String[] args) {
		String locn = "./src/test/java/com/kata/series/io/files/PathExplorationFile.txt";
		Path path = Paths.get(locn);
		printPathInfo(path);
		logStatements(path);
		extraInfo(path);
	}

	public static void printPathInfo(Path path) {
		System.out.println("Path path :" + path);
		System.out.println("File Name :" + path.getFileName());
		System.out.println("Parent : " + path.getParent());
		Path absolutePath = path.toAbsolutePath();
		System.out.println("Root :" + absolutePath.getRoot());
		System.out.println("Root from path :" + path.getRoot());
		System.out.println("isAbsolute :" + path.isAbsolute());
		System.out.println("-".repeat(10));
	}

	public static void logStatements(Path path) {
		try {
			Path parent = path.getParent();
			if (!Files.exists(parent)) {
				Files.createDirectories(parent);
			}
			Files.writeString(path, Instant.now() + " : Hello World From Files Java NIO2", StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void extraInfo(Path path) {
		try {
			System.out.println();
			System.out.println("Printing Attributes");
			Map<String, Object> atts = Files.readAttributes(path, "*");
			atts.entrySet().forEach(System.out::println);
			Files.probeContentType(path);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
