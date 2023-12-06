package com.kata.series.e1.challenge1.tyre;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("NO_BOOT")
@Component(value = "michilin")
public class MichilinTyre implements Tyre {

	@Override
	public String rotate() {
		return " Michilin types : move ....";
	}

}
