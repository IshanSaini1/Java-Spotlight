package com.kata.series.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOMain1 {

	public static void main(String[] args) throws IOException {

		System.out.println("Current Working Directory (cwd) = " + new File("").getAbsolutePath());

		String filename1 = "src/test/java/com/kata/series/io/files/testing.csv";
		String filename2 = "src/test/java/com/kata/series/io/files/testing2.csv";

		File file = new File(".", filename1);

		System.out.println(file.getAbsolutePath());

		if (!file.exists()) {
			System.out.println("I can't run unless this file exists, So creating one");
			file.createNewFile();
		}
		System.out.println("I'm good to go.");
		
		
		Path path = Paths.get("./src/test/java/com/kata/series/io/files/testing.csv");
		
		if (!Files.exists(path)) {
			System.out.println("2. I can't run unless this file exists, So creating one");
			file.createNewFile();
		}
		System.out.println("2. I'm good to go.");

	}
	/*
	 * for (File f : File.listRoots()) { System.out.println(f); }
	 * 
	 * Path path = Paths.get("/src/test/java/com/kata/series/io/files/testing.csv");
	 * System.out.println(file.getAbsolutePath()); if (!Files.exists(path)) {
	 * System.out.println("2. I can't run unless this file exists"); return; }
	 * System.out.println("2. I'm good to go.");
	 */

	private static void testFile(String filename) {

		Path path = Paths.get(filename);
		FileReader reader = null;
		try {
//	            List<String> lines = Files.readAllLines(path);
			reader = new FileReader(filename);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			System.out.println("Maybe I'd log something either way...");
		}
		System.out.println("File exists and able to use as a resource");
	}

	private static void testFile2(String filename) {

		try (FileReader reader = new FileReader(filename)) {
		} catch (FileNotFoundException e) {
			System.out.println("File '" + filename + "' does not exist");
			throw new RuntimeException(e);
		} catch (NullPointerException | IllegalArgumentException badData) {
			System.out.println("User has added bad data " + badData.getMessage());
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			System.out.println("Something unrelated and unexpected happened");
		} finally {
			System.out.println("Maybe I'd log something either way...");
		}
		System.out.println("File exists and able to use as a resource");
	}
}
