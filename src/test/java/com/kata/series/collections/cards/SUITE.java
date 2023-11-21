package com.kata.series.collections.cards;

public enum SUITE {
	CLUB, DIAMOND, HEART, SPADE;

	public char getAsciiValueofSuite(SUITE suite) {
		switch (suite) {
		case CLUB:
			return 9827;
		case DIAMOND:
			return 9830;
		case HEART:
			return 9829;
		case SPADE:
			return 9824;
		default:
			return 9827;
		}
	}

	public char getImage() {
		return (new char[] { 9827, 9830, 9829, 9824 })[this.ordinal()];
	}
}
