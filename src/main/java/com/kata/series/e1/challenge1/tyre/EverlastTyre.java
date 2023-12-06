package com.kata.series.e1.challenge1.tyre;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("NO_BOOT")
@Component(value = "everlast")
public class EverlastTyre implements Tyre {

	@Override
	public String rotate() {
		return "Everlast Tyre : Rotate .....";
	}

}
