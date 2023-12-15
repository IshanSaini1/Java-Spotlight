package com.kata.series.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kata.series.model.Person;
import com.kata.series.repository.PersonRepository;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class DashboardController {

	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping(value = "/dashboard", method = { RequestMethod.GET })
	public String displayDashBoard(Model model, Authentication authentication, HttpSession session) {
		Map<String,String> map = (Map<String, String>) authentication.getDetails();
		String email = map.get("email");
		Person person = personRepository.findByEmail(email);
		boolean flag = false;
		model.addAttribute("username", authentication.getName());
		model.addAttribute("roles", authentication.getAuthorities().toString());
		if(flag) {
		throw new RuntimeException("Its a bad day today");
		}
		session.setAttribute("person", person);
		return "dashboard.html";
	}
}
