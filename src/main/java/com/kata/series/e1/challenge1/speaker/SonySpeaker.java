package com.kata.series.e1.challenge1.speaker;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("NO_BOOT")
@Component(value = "sony")
public class SonySpeaker implements Speaker {

	@Override
	public String makeSound() {
		return "Sony Speaker : make sound !!!!!";
	}

}
