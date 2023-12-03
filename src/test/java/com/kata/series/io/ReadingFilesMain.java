package com.kata.series.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadingFilesMain {

	public static void main(String args[]) {
		final String FILE_NAME = "./src/test/java/com/kata/series/io/files/ReadFile.txt";
		try (FileReader fileReader = new FileReader(FILE_NAME);) {

			int data;
			while ((data = fileReader.read()) != -1) {
				System.out.println((char) data);
			}

		} catch (RuntimeException | IOException i) {
			System.out.println("Something went worng . look below :");
			i.printStackTrace();

		} finally {
			System.out.println("Log something !!");
		}

		System.out.println("-".repeat(50));

		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			var var1 = reader.lines().map(String::toCharArray).collect(() -> new ArrayList<Character>(), (t, u) -> {
				for (Character c : u) {
					t.add(c);
				}
			}, (t, u) -> t.addAll(u));

			var1.stream().forEach(x -> System.out.println(x));

		} catch (RuntimeException | IOException i) {
			System.out.println("Something went worng . look below :");
			i.printStackTrace();

		} finally {
			System.out.println("Log something !! for Buffered Reader");
		}
	}
}
