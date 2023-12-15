package com.kata.series.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kata.series.mapper.PersonToProfileMapper;
import com.kata.series.model.Person;
import com.kata.series.model.Profile;
import com.kata.series.repository.PersonRepository;
import com.kata.series.service.ProfileService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProfileController {

	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private PersonRepository personRepo;
	
	@RequestMapping("/displayProfile")
	public ModelAndView displayMessage(Model model, Authentication auth) {
		Map<String,String> map =   (Map<String, String>) auth.getDetails();
		String email = map.get("email");
		Profile profile = profileService.getBasicProfileDetails(email);
		ModelAndView modelAndView = new ModelAndView("profile.html");
		modelAndView.addObject("profile", profile);
		return modelAndView;
	}
	
	@PostMapping("/updateProfile")
	public String updateProfile(@Valid @ModelAttribute("profile") Profile profile, Errors error, HttpSession session) {
		if(error.hasErrors()) {
			return "profile.html";
		}
		Person person = (Person) session.getAttribute("person");
		PersonToProfileMapper.mapper.profileToPerson(profile);
		person = personRepo.save(person);
		session.setAttribute("person", person);
		return "redirect:/displayProfile";
	}
}
