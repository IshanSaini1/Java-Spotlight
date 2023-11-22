package com.kata.series.collections.contract_sets;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Contact {
	private String name;
	private Set<String> emails = new HashSet<>();
	private Set<String> phones = new HashSet<>();

	public Contact(String name) {
		this(name, null);
	}

	public Contact(String name, String email) {
		this(name, email, 0l);
	}

	public Contact(String name, long phone) {
		this(name, null, phone);
	}

	public Contact(String name, String email, long phone) {
		this.name = name;
		if (null != email && !email.isBlank() && !email.isEmpty()) {
			emails.add(email);
		}
		if (phone > 0) {
			String p = String.valueOf(phone);
			p = "(%s) %s-%s".formatted(p.substring(0, 3), p.substring(3, 6), p.substring(6));
			phones.add(p);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", emails=" + emails + ", phones=" + phones + "]";
	}

	public Contact mergeContactData(Contact contact) {
		Contact newContact = new Contact(name);
		newContact.emails = new HashSet<>(this.emails);
		newContact.phones = new HashSet<>(this.phones);
		newContact.emails.addAll(contact.emails);
		newContact.phones.addAll(contact.phones);
		return newContact;
	}

	@Override
	public int hashCode() {
		return 33 * getName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return this.getName().equals(other.getName());
	}

	public void addEmail(String companyName) {
		String[] names = name.split(" ");
		String email = "%c%s@%s.com".formatted(name.charAt(0), names[names.length - 1],
				companyName.replaceAll(" ", "").toLowerCase());
		if (!emails.add(email)) {
			System.out.println("Duplicate avaiable for " + companyName);
		} else {
			System.out.println("Added");

		}
	}

}
