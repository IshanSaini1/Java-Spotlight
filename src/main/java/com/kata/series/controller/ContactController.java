package com.kata.series.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kata.series.model.Contact;
import com.kata.series.service.ContactService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ContactController {

	private ContactService contactService;

	@RequestMapping("/contact")
	public String displayContactPage(Model model) {
		model.addAttribute("contact", new Contact());
		return "contact.html";
	}

	@PostMapping("/saveMsg")
	public String saveMessageNew(@Valid @ModelAttribute("contact") Contact c, Errors error) {
		if (error.hasErrors()) {
			log.error("Error has ocurred in contact : " + error.toString());
			return "contact.html";
		}
		contactService.setCounter(contactService.getCounter() + 1);
		contactService.saveMessageDetails(c);
		log.info(" Counter Value at : " + contactService.getCounter());

		return "redirect:/contact";
	}

	@GetMapping("/displayMessages/page/{pageNum}")
	public ModelAndView displayMessages(Model model, @PathVariable("pageNum") int pageNum,
			@RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir) {
		Page<Contact> msgPage = contactService.findMsgsWithOpenStatus(pageNum, sortField, sortDir);
		List<Contact> contactMsgs = msgPage.getContent();
		ModelAndView modelAndView = new ModelAndView("messages.html");
		model.addAttribute("currentPage", pageNum);
		model.addAttribute("totalPages", msgPage.getTotalPages());
		model.addAttribute("totalMsgs", msgPage.getTotalElements());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		modelAndView.addObject("contactMsgs", contactMsgs);
		return modelAndView;
	}

	@Deprecated
	public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,
			@RequestParam String email, @RequestParam String subject, @RequestParam String message) {
		System.out.printf("%n Name : %s %n Mobile Number : %s %n Email : %s %n Subject : %s %n Message : %s %n", name,
				mobileNum, email, subject, message);
		return new ModelAndView("redirect:/contact");
	}

	@Autowired
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	@RequestMapping(value = "/closeMsg", method = RequestMethod.GET)
	public String closeMessageController(@RequestParam("id") int id, Authentication auth) {
		contactService.updateMsgStatus(id, auth.getName());
		return "redirect:/displayMessages/page/1?sortField=name&sortDir=desc";
	}
}
