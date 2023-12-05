package com.kata.series.e1.challenge1.speaker;

import org.springframework.stereotype.Component;

@Component(value = "bose")
public class BoseSpeaker implements Speaker {

	@Override
	public String makeSound() {
		return "Bose Speaker : make sound !!!";
	}

}
