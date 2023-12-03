package com.kata.series.io.data;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Objective : Writing the Objects to a file
 */
public class DataStreamMain {

	private static final String PATH = "./src/test/java/com/kata/series/io/files";
	private static final String FILE_NAME = "/ObjectTest1.txt";

	public static void main(String[] args) {

		Path path = Path.of(PATH + FILE_NAME);
		writeData(path);
		System.out.println("-".repeat(60));
		readData(path);
		System.out.println("-".repeat(10));
		Player tim = new Player("Tim", 10, List.of("Pistol", "Sword"));
		System.out.println(tim);
		writeObject(path, tim);
		System.out.println("-".repeat(10));
		Player readPerson = readPlayerData(path);
		System.out.println(" Player data read for : " + readPerson);
	}

	private static void readData(Path path) {
		try (DataInputStream ds = new DataInputStream(Files.newInputStream(path))) {
			System.out.println("" + ds.readInt());
			System.out.println("" + ds.readBoolean());
			System.out.println("" + ds.readLong());
			System.out.println("" + ds.readChar());
			System.out.println("" + ds.readFloat());
			System.out.println("" + ds.readDouble());
			System.out.println("" + ds.readUTF());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void writeData(Path dataFile) {
		try (DataOutputStream dataOutput = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream(dataFile.toFile())))) {
			int myInt = 100;
			long myLong = 10000_0000_000L;
			boolean myBoolean = Boolean.TRUE;
			char myChar = 'Z';
			float myFloat = 10.001f;
			double myDouble = 11.2230d;
			String myString = "Hello World";
			List<String> list = List.of("Hello", "World", "One");

			long position = 0;
			dataOutput.writeInt(myInt);
			System.out.println("myInt writes : " + (dataOutput.size() - position));
			position = dataOutput.size();

			dataOutput.writeBoolean(myBoolean);
			System.out.println(" writes : " + (dataOutput.size() - position));
			position = dataOutput.size();

			dataOutput.writeLong(myLong);
			System.out.println("writes : " + (dataOutput.size() - position));
			position = dataOutput.size();

			dataOutput.writeChar(myChar);
			System.out.println(" writes : " + (dataOutput.size() - position));
			position = dataOutput.size();

			dataOutput.writeFloat(myFloat);
			System.out.println(" writes : " + (dataOutput.size() - position));
			position = dataOutput.size();

			dataOutput.writeDouble(myDouble);
			System.out.println("myDouble writes : " + (dataOutput.size() - position));
			position = dataOutput.size();

			dataOutput.writeUTF(myString);
			System.out.println("myStrign writes : " + (dataOutput.size() - position));
			position = dataOutput.size();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

	private static void writeObject(Path path, Player player) {
		try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
			oos.writeObject(player);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Object has been written to file");
		}
	}

	private static Player readPlayerData(Path path) {
		try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
			return (Player) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
