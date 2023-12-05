package com.kata.series.e1.challenge1.tyre;

import org.springframework.stereotype.Component;

@Component(value = "everlast")
public class EverlastTyre implements Tyre {

	@Override
	public String rotate() {
		return "Everlast Tyre : Rotate .....";
	}

}
