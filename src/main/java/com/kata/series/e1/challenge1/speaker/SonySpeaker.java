package com.kata.series.e1.challenge1.speaker;

import org.springframework.stereotype.Component;

@Component(value = "sony")
public class SonySpeaker implements Speaker {

	@Override
	public String makeSound() {
		return "Sony Speaker : make sound !!!!!";
	}

}
