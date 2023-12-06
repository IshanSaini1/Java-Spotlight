package com.kata.series.e1.aspects.objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.kata.series.e1.aspects.annotations.LogMethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Profile("NO_BOOT")
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
	
	@LogMethod
	public String sayImportantMessage() {
		return String.format(" Student %s : Shhh.... this... is my secret code ", name); 
	}

}
