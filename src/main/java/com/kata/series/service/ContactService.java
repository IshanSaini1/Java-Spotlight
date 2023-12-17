package com.kata.series.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.kata.series.constants.EazySchoolConstants;
import com.kata.series.model.Contact;
import com.kata.series.repository.ContactRepository;
import com.kata.series.repository.ContactRepositoryJPA;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
//@RequestScope
//@SessionScope
//@ApplicationScope
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private ContactRepositoryJPA contactRepositoryJPA;

	private int counter = 0;

	public ContactService() {
		System.out.println("Contact Service Bean Initialized");
	}

	public boolean saveMessageDetails(Contact contact) {
		boolean isSaved = false;
		log.info("Message Saved " + contact.toString());
		contact.setStatus(EazySchoolConstants.OPEN);
		var result = contactRepositoryJPA.save(contact);
		if (null != result) {
			isSaved = true;
		}
		log.info("Exiting : Save Success : " + isSaved);
		return isSaved;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public Page<Contact> findMsgsWithOpenStatus(int pageNum, String sortField, String sortDir) {
		int pageSize = 5;
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
				sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
		Page<Contact> msgPage = contactRepositoryJPA.findOpenMsg(EazySchoolConstants.OPEN, pageable);
		return msgPage;
		// contactRepositoryJPA.findByStatus(EazySchoolConstants.OPEN);
	}

	public void updateMsgStatus(int id, String name) {
		//// Contact contact = contactRepositoryJPA.findById(id).orElseThrow(()-> new
		//// RuntimeException("No Contact found with this Id"));
		//// contact.setStatus(EazySchoolConstants.CLOSE);
		// Is now done by annotations and Audit Configuration in configs package
		// contact.setUpdatedBy(name);
		// contact.setUpdatedAt(LocalDateTime.now());
		//// contactRepositoryJPA.save(contact);
		// contactRepository.updateMsgStatus(id, EazySchoolConstants.CLOSE, name);
		int modifiedRows = contactRepositoryJPA.updateStatusById(id, EazySchoolConstants.CLOSE);
		log.info("Modified Rows : " + modifiedRows);
	}

}
