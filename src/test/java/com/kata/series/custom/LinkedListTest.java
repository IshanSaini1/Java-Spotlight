package com.kata.series.custom;

import java.util.LinkedList;
import java.util.ListIterator;

import org.junit.jupiter.api.Test;

public class LinkedListTest {

	// @Test
	void LinkedListTest() {
		LinkedList<String> places_to_visit = new LinkedList<>();
		places_to_visit.add("Sydney");
		places_to_visit.add("Canberra");

		addMoreElementsToList(places_to_visit);

		System.out.println(places_to_visit);
		removeElements(places_to_visit);
		addMoreElementsToList(places_to_visit);
		retrieveElements(places_to_visit);
	}

	private static void addMoreElementsToList(LinkedList<String> list) {
		list.addFirst("Haryana");
		list.addLast("Punjab");
		list.offer("Delhi");
		list.push("Congo");
		System.out.println("Final Entry " + list);
	}

	private static void removeElements(LinkedList<String> list) {
		list.remove(0);
		list.remove("Haryana");
		System.out.println("Final Entry " + list);
		list.removeFirst();
		list.poll();
		list.pop();
		System.out.println("Final Entry " + list);
	}

	@Test
	 void LinkedListChallenge() {
		LinkedList<Town> townList = new LinkedList<>();
		addAllTowns(townList);
		traverseList(townList);
	}

	private static void retrieveElements(LinkedList<String> list) {
		System.out.println("  " + list.get(0) + "  " + list.getFirst() + "  " + list.getLast() + "  " + list.element()
				+ " " + list.peek());
	}

	private void traverseList(LinkedList<Town> list) {
		System.out.print("First Place to visit -> " + "Sydney");
		list.sort((o1, o2) -> o1.distance-o2.distance );
		ListIterator<Town> it = list.listIterator();
		while(it.hasNext()) {
			System.out.print(" -> " +it.next().town);
		}
	}

	private void addAllTowns(LinkedList<Town> list) {
		list.add(new Town("Adelaide", 1374));
		list.add(new Town("Alice Springs", 2771));
		list.add(new Town("Brisbane", 917));
		list.add(new Town("Darwin", 3972));
		list.add(new Town("Melborne", 877));
		list.add(new Town("Perth", 3923));
	}

	record Town(String town, Integer distance) {
		@Override
		public String toString() {
			return String.format("(%s)  (%d)", town, distance);
		}
	}
}
