package com.kata.series.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kata.series.model.Contact;
import com.kata.series.repository.ContactRepositoryJPA;


//@Controller
@RestController
@RequestMapping(value = "/api/contact")
public class ContactRestController {

	@Autowired
	ContactRepositoryJPA contactRepository;

	@GetMapping("/getMessagesByStatus")
	//@ResponseBody
	public List<Contact> getMessagesByStatus(@RequestParam(name = "status") String status) {
		return contactRepository.findByStatus(status);
	}
	
	@GetMapping("/getAllMsgsByStatus")
	//@ResponseBody
	public List<Contact> getAllMsgsByStatus(@RequestBody Contact contact){
		return contactRepository.findByStatus(contact.getStatus());
	}
}
