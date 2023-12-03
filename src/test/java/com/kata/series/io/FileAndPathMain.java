package com.kata.series.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileAndPathMain {

	public static void main(String[] args) {
		String fileName = "./src/test/java/com/kata/series/io/files/testFile.txt";
		String pathFileName = "./src/test/java/com/kata/series/io/files/pathFile.txt";
		useFile(fileName);
		usePath(pathFileName);

	}

	private static void useFile(String fileName) {
		File file = new File(fileName);
		boolean fileExists = file.exists();
		System.out.printf("%n File : %s %s%n", fileName, (fileExists) ? "Exists .." : " is Missing");
		if (fileExists) {
			System.out.println("Deleting the File : " + fileName);
			fileExists = !file.delete();
		}

		if (!fileExists) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Something went wrong when creating the file named :" + fileName);
				e.printStackTrace();
			}
			System.out.println("\nNew File named : " + fileName + " is Created\n");
			if (file.canWrite()) {
				System.out.println("We will write to the file here.");
			}
		}
	}

	private static void usePath(String fileName) {
		Path file = Path.of(fileName);
		boolean fileExists = Files.exists(file);
		System.out.printf("%n File : %s %s%n", fileName, (fileExists) ? "Exists .." : " is Missing");
		if (fileExists) {
			System.out.println("Deleting the File : " + fileName);
			try {
				Files.delete(file);

				fileExists = false;

				if (!fileExists) {
					try {
						Files.createFile(file);
					} catch (IOException e) {
						System.out.println("Something went wrong when creating the file named :" + fileName);
						e.printStackTrace();
					}
					System.out.println("\nNew File named : " + fileName + " is Created\n");
					if (Files.isWritable(file)) {
						Files.writeString(file, """
								This is the way of the text block.
								Files is much better than Old file methods.
								This is the difference between File and Files.
								""", StandardOpenOption.WRITE);
					}
					System.out.println("Files can also read from other files....");
					Files.readAllLines(file).stream().forEach(System.out::println);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
