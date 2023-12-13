package com.kata.series.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class DashboardController {

	@RequestMapping(value = "/dashboard", method = { RequestMethod.GET })
	public String displayDashBoard(Model model, Authentication authentication) {
		boolean flag = false;
		model.addAttribute("username", authentication.getName());
		model.addAttribute("roles", authentication.getAuthorities().toString());
		if(flag) {
		throw new RuntimeException("Its a bad day today");
		}
		return "dashboard.html";
	}
}
