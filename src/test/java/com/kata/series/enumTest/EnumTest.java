package com.kata.series.enumTest;

public  class EnumTest {

	public enum Numbers {
		ONE("I"), TWO("II"), THREE("III"), FOUR("IV"), FIVE("V"),SIX;

		String romanNumber;

		Numbers(String s) {
			romanNumber = s;
		}

		Numbers() {
			this.romanNumber = "0";
		}

		String getRomanNumber() {
			return romanNumber;
		}

	}

	public static void main(String[] args) {
		System.out.println(Numbers.SIX + " : " + Numbers.SIX.romanNumber + " : " + Numbers.THREE + "  "
				+ Numbers.THREE.romanNumber);

	}

}
