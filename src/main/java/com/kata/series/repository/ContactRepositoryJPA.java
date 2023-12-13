package com.kata.series.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kata.series.model.Contact;

@Repository
public interface ContactRepositoryJPA extends JpaRepository<Contact, Integer> {

	public Contact findByContactId(Integer contactId);
	public List<Contact> findByStatus(String constant);
}
