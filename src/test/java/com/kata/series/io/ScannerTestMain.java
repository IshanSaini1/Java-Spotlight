package com.kata.series.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTestMain {

	private final static String FILE_NAME = "./src/test/java/com/kata/series/io/files/test.txt";

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new File(FILE_NAME))) {
			while (sc.hasNext()) {
				String line = sc.nextLine();
				System.out.println(line);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Good Coding Practice Logging");
		}
	}

}
