package com.kata.series.collections.contract_sets;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactMain {

	public static void main(String[] args) {
		List<Contact> emails = ContactData.getData("email");
		List<Contact> phones = ContactData.getData("phone");
		printData("Phone List", phones);
		printData("Email List", emails);

		Set<Contact> emailCotacts = new HashSet<>(emails);
		Set<Contact> phoneContacts = new HashSet<>(phones);

		int index = emails.indexOf(new Contact("Robin Hood"));
		Contact robinHood = emails.get(index);
		robinHood.addEmail("Sherwood Forest");
		System.out.println(robinHood);
		
	}

	public static void printData(String header, Collection<Contact> contacts) {
		System.out.println("------------------");
		System.out.println(header);
		System.out.println("------------------");
		contacts.forEach(System.out::println);
	}

}
