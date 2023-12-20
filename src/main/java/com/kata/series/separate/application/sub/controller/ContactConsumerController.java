package com.kata.series.separate.application.sub.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kata.series.model.Contact;
import com.kata.series.separate.application.ContactProxy;

@RestController
@RequestMapping(path = "/api/consume/contact")
public class ContactConsumerController {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ContactProxy contactProxy;

	@GetMapping("/getMessages")
	private List<Contact> getMessages(@RequestParam("status") String status) {
		List<Contact> listOfMessages = contactProxy.getMessagesByStatus(status);
		log.info("We got : \n"+listOfMessages+"\n from API.");
		return listOfMessages;
	}

}
