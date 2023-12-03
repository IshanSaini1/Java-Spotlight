package com.kata.series.io.data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ObjectStreamMain {

	public static void main(String[] args) {
		String p = "./src/test/java/com/kata/series/io/files/ObjectTest1.txt";
		Path path = Path.of(p);
		Player tim = readPlayerData(path);
		System.out.println("Player found : " + tim);
		

	}

	private static Player readPlayerData(Path path) {
		try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
			return (Player) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Some Exception has Occured");
			e.printStackTrace();
			return null;
		}
	}

}
