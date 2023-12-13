package com.kata.series.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String displayHomePage(Model model) {
		String userName = "Ishan Saini";
		return "home.html";
	}

	@RequestMapping("/403")
	public String accessDenied(Model model) {
		return "accessdenied.html";
	}

}
