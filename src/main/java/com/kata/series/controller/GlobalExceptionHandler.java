package com.kata.series.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice(annotations = Controller.class)
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandler(Exception exception) {
		ModelAndView errorPage = new ModelAndView();
		log.info("Error has Occurred in Page");
		errorPage.setViewName("/error");
		errorPage.addObject("errormsg", exception.getMessage());
		exception.printStackTrace();
		return errorPage;

	}

}
