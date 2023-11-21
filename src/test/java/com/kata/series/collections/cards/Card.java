package com.kata.series.collections.cards;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Card {
	SUITE suite;
	String face;
	Integer rank;

	@Override
	public String toString() {
		int index = face.equals("10") ? 2 : 1;
		String faceString = face.substring(0, index);
		return "%s%c{%d}".formatted(faceString, suite.getImage(), rank);
	}

	public static Card getNumberiCard(SUITE suite, int cardNumber) {

		if (cardNumber > 1 && cardNumber < 11) {
			return new Card(suite, String.valueOf(cardNumber), cardNumber - 2);
		}
		System.out.println("Invalid Number here");
		return null;
	}

	public static Card getFaceCard(SUITE suite, char abbrev) {
		int charIndex = "JQKA".indexOf(abbrev);
		if (charIndex > -1) {
			return new Card(suite, "" + abbrev, charIndex + 9);
		}
		System.out.println("Invalid face Card Selected");
		return null;
	}

	public static List<Card> getStandardDeck() {
		List<Card> deck = new ArrayList<>(52);
		for (SUITE suite : SUITE.values()) {
			for (int i = 2; i <= 10; i++) {
				deck.add(getNumberiCard(suite, i));
			}
			for (char c : new char[] { 'J', 'Q', 'K', 'A' }) {
				deck.add(getFaceCard(suite, c));
			}
		}
		return deck;
	}

	public static void printDeck(List<Card> deck, String description, int rows) {
		System.out.println("-------------------");
		if (description != null) {
			System.out.println(description);
		}
		int cardsInRow = deck.size() / rows;
		for (int i = 0; i < rows; i++) {
			int startIndex = i * cardsInRow;
			int endIndex = startIndex + cardsInRow;
			deck.subList(startIndex, endIndex).forEach(c -> System.out.print(c + " "));
			System.out.println();
		}
	}

	public static void printDeck(List<Card> deck) {
		System.out.println("-------------------");
		printDeck(deck, "Current Deck Default", 4);
	}
}
