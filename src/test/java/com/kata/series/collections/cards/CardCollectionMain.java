package com.kata.series.collections.cards;

import java.util.List;

public class CardCollectionMain {

	public static void main(String args[]) {
		List<Card> deck = Card.getStandardDeck();
		Card.printDeck(deck);
	}
}
