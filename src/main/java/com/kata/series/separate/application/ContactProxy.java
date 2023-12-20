package com.kata.series.separate.application;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kata.series.model.Contact;
import com.kata.series.separate.application.config.ProjectConfiguration;

import feign.Headers;

@FeignClient(name = "contact", url = "http://localhost:8080/api/contact", configuration = ProjectConfiguration.class)
public interface ContactProxy {

	@GetMapping("/getMessagesByStatus")
	@Headers(value = "Content-Type: application/json")
	public List<Contact> getMessagesByStatus(@RequestParam("status") String status);
}
