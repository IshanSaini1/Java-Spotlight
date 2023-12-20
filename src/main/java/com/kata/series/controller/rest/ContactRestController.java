package com.kata.series.controller.rest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kata.series.constants.EazySchoolConstants;
import com.kata.series.model.Contact;
import com.kata.series.model.rest.Response;
import com.kata.series.repository.ContactRepositoryJPA;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

//@Controller
@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/contact")
public class ContactRestController {

	@Autowired
	ContactRepositoryJPA contactRepository;

	@GetMapping("/getMessagesByStatus")
	// @ResponseBody
	public List<Contact> getMessagesByStatus(@RequestParam(name = "status") String status) {
		return contactRepository.findByStatus(status);
	}

	@GetMapping("/getAllMsgsByStatus")
	// @ResponseBody
	public List<Contact> getAllMsgsByStatus(@RequestBody Contact contact) {
		return contactRepository.findByStatus(contact.getStatus());
	}

	@PostMapping("/saveMsg")
	public ResponseEntity<Response> saveMsg(@RequestHeader("invocationFrom") String invocationFrom,
			@Valid @RequestBody Contact contact) {
		log.info(" API is invoked from : " + invocationFrom);
		contactRepository.save(contact);
		Response response = new Response();
		response.setStatusCode("200");
		response.setStatusMsg("Message is saved successfully");
		return ResponseEntity.status(HttpStatus.CREATED).header("isMsgSaved", "true").body(response);
	}

	@DeleteMapping("/deleteMsg")
	public ResponseEntity<Response> deleteMsg(RequestEntity<Contact> requestEntity) {
		HttpHeaders header = requestEntity.getHeaders();
		header.forEach((key, value) -> {
			log.info(String.format("Header '%s' = %s ", key, value.stream().collect(Collectors.joining("|"))));
		});
		Contact contact = requestEntity.getBody();
		contactRepository.deleteById(contact.getContactId());
		Response response = new Response();
		response.setStatusCode("200");
		response.setStatusMsg("Message successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PatchMapping("/closeMsg")
	public ResponseEntity<Response> closeMsg(@RequestBody Contact contactReq, HttpServletResponse http) {
		Boolean isUpdated = false;
		Response response = new Response();
		Optional<Contact> contact = contactRepository.findById(contactReq.getContactId());
		if (contact.isPresent()) {
			Contact c = contact.get();
			c.setStatus(EazySchoolConstants.CLOSE);
			contactRepository.save(c);
			isUpdated = true;
			response.setStatusCode("200");
			response.setStatusMsg("Message Closed Successfully.");
		} else {
			response.setStatusCode("304");
			response.setStatusMsg("Error : System was not able to close message.");
		}

		return ResponseEntity.status(HttpStatus.OK).header("isUpdated", isUpdated.toString()).body(response);
	}

}
