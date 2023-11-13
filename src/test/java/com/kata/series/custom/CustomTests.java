package com.kata.series.custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class CustomTests {

	// @Test
	void ArraysInJava() {
		GroceryItems[] groceryArray = new GroceryItems[3];
		GroceryItems obj1 = new GroceryItems("Milk");
		GroceryItems obj2 = new GroceryItems("Apples", "Produce", 6);
		GroceryItems obj3 = new GroceryItems("Cheese");
		groceryArray[0] = obj1;
		groceryArray[1] = obj2;
		groceryArray[2] = obj3;
		System.out.println(Arrays.toString(groceryArray));
		System.out.println("Continue list from here :");
		ArrayList<GroceryItems> arrayList = new ArrayList<>();
		arrayList.add(obj1);
		arrayList.add(obj2);
		arrayList.set(0, obj3);
		arrayList.set(1, obj3);
		System.out.println("[0] : " + arrayList.get(0).hashCode() + "[1] : " + arrayList.get(1).hashCode());
		arrayList.remove(1);
		arrayList.removeIf(x -> x.type().equalsIgnoreCase("Dairy"));
		arrayList.forEach(System.out::println);
		arrayList.indexOf(obj3);
	}

	// @Test
	void moreLists() {
		String[] items = { "apples", "banana", "milk", "oranges" };
		List<String> list = List.of(items);
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		ArrayList<String> arrList = new ArrayList<>(list);
		arrList.sort(Comparator.reverseOrder());
		arrList.forEach(x -> System.out.println(" " + x + " "));
	}

	@Test
	void ArrayListChallenge() {
		Scanner sc = new Scanner(System.in);
		List<Object> list = new ArrayList<>();
		String menu = String.format("\n 0 - ShutDown \n" + " 1 - To Add items to a list \n"
				+ " 2 - Remove items by index \n" + " 3 - Remove items by value \n" + " 4 - Print List \n");

		while (true) {
			System.out.println(menu);
			int option = sc.nextInt();
			switch (option) {
			case 0: {
				sc.close();
				System.exit(0);
				break;
			}
			case 1: {
				System.out.println("Input the item to add ?");
				String item = sc.next();
				list.add(item);
				break;
			}
			case 2: {
				System.out.println("Input the index of which the value is to be deleted :");
				int index = sc.nextInt();
				list.remove(index);
				break;
			}
			case 3: {
				System.out.println(" Imput the item value to be deleted :");
				Object item = sc.next();
				list.remove(item);
				break;
			}
			case 4: {
				System.out.println(" List is Below ");
				list.forEach(x -> System.out.print(x + "  "));
				break;
			}

			}
		}

	}

}

record GroceryItems(String name, String type, int count) {
	public GroceryItems(String name) {
		this(name, "DAIRY", 1);
	}
}
