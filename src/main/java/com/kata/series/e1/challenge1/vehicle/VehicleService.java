package com.kata.series.e1.challenge1.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.kata.series.e1.challenge1.speaker.Speaker;
import com.kata.series.e1.challenge1.tyre.Tyre;

@Component
public class VehicleService {

	@Qualifier("sony")
	@Autowired
	private Speaker speaker;

	@Qualifier("everlast")
	@Autowired
	private Tyre tyre;

	public Speaker getSpeaker() {
		return speaker;
	}

	public Tyre getTyre() {
		return tyre;
	}

}
