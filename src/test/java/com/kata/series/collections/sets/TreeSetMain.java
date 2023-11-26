package com.kata.series.collections.sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;

import com.kata.series.collections.contract_sets.Contact;
import com.kata.series.collections.contract_sets.ContactData;

public class TreeSetMain {
	public static void main(String args[]) {
		List<Contact> phones = ContactData.getData("phone");
		List<Contact> emails = ContactData.getData("email");

		// NavigableSet<Contact> sorted = new TreeSet<>(phones);

		Comparator<Contact> mySort = Comparator.comparing(Contact::getName);
		NavigableSet<Contact> sorted = new TreeSet<>(mySort);
		sorted.addAll(phones);
		sorted.forEach(System.out::println);

		NavigableSet<String> justNames = new TreeSet<>();
		phones.forEach(c -> justNames.add(c.getName()));
		System.out.println(justNames);

		NavigableSet<Contact> fullSet = new TreeSet<>(sorted);
		fullSet.addAll(emails);
		fullSet.forEach(System.out::println);

		List<Contact> fullList = new ArrayList<>(phones);
		fullList.addAll(phones);
		fullList.sort(sorted.comparator());
		System.out.println("-----------------");
		fullList.forEach(x -> System.out.println(x));

		Contact min = Collections.min(fullSet, fullSet.comparator());
		Contact max = Collections.max(fullSet, fullSet.comparator());
		Contact first = fullSet.first();
		Contact last = fullSet.last();
		System.out.println("min :" + min.getName() + "  " + " max : " + max.getName());
		System.out.println("min :" + first.getName() + "  " + " max : " + last.getName());
		
		NavigableSet<Contact> copiedSet = new TreeSet<>(fullSet);
		System.out.println("First Element : "+copiedSet.pollFirst());
		System.out.println("Last Element : "+copiedSet.pollLast());
		
	}
}
