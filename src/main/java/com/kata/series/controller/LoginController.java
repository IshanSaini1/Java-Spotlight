package com.kata.series.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String displayLoginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		String errorMessge = null;
		if (error != null) {
			errorMessge = "Username or password is Incorrect";
		}
		if (logout != null) {
			errorMessge = "You have logged out successfully";
		}
		model.addAttribute("errorMessge", errorMessge);
		return "login.html";
	}

	@RequestMapping(value = "/logout", method = { RequestMethod.GET })
	public String displayLogoutPage(HttpServletRequest req, HttpServletResponse resp, Authentication auth) {
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(req, resp, auth);
		}
		return "redirect:/login?logout=true";
	}

}
