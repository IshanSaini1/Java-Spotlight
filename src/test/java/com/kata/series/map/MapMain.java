package com.kata.series.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.kata.series.collections.contract_sets.Contact;
import com.kata.series.collections.contract_sets.ContactData;

public class MapMain {
	public static void main(String args[]) {
		List<Contact> phones = ContactData.getData("phones");
		List<Contact> emails = ContactData.getData("email");

		List<Contact> fullList = new ArrayList<>(phones);
		fullList.addAll(emails);
		fullList.forEach(System.out::println);
		System.out.println("------------------------");

		Map<String, Contact> contacts = new HashMap<>();
		for (Contact contact : fullList) {
			contacts.put(contact.getName(), contact);
		}
		contacts.forEach((k, v) -> System.out.println("Key : " + k + " value = " + v));

		ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));

		System.out.println("--------------------");
		System.out.println("Value : " + contacts.get("Minnie Mouse"));
		Map<String, Contact> newMap = new TreeMap<>((o1, o2) -> o1.compareTo(o2));
		ContactData.getData("email").forEach(x -> newMap.put(x.getName(), x));
		var newMapEntry = newMap.entrySet();
		// newMap.entrySet().forEach(System.out::println);
		for (var node : newMapEntry) {
			if (node.getKey().equals(node.getValue().getName())) {
				System.out.println("Key does not match any name");
			}
		}

	}

}
