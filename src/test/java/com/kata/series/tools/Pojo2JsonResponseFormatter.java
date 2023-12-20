package com.kata.series.tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.series.model.Contact;

public class Pojo2JsonResponseFormatter {

	public static void main(String args[]) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String pojoRequest = objectMapper.writer().writeValueAsString(new Contact());
			System.out.println(pojoRequest);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
