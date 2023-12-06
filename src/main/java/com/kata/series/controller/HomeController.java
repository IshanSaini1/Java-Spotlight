package com.kata.series.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(path = { "/", "", "/home" })
	public String displayHomePage(Model model) {
		String userName = "Ishan Saini";
		Map<String, String> modelMap = new HashMap<>();

		modelMap.put("username", userName);
		// model.addAttribute("username", userName);
		model.addAllAttributes(modelMap);
		return "home.html";
	}

}
