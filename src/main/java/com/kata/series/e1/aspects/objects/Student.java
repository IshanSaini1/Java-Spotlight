package com.kata.series.e1.aspects.objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	private String name = "ISHAN";

	@Qualifier("DIV10")
	@Autowired
	private Division division;

	public String sayHello() {
		return String.format(" Student %s : Says Hello to you ... ", name);
	}

}
