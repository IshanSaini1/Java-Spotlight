package com.kata.series.e1.challenge1.tyre;

public class TyreFactory {

	public static Tyre getTyre(int tyreNumber) {
		switch (tyreNumber) {
		case 0:
			return new MichilinTyre();
		case 1:
			return new EverlastTyre();
		default:
			return new MichilinTyre();
		}
	}
}
