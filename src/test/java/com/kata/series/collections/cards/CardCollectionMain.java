package com.kata.series.collections.cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardCollectionMain {

	public static void main(String args[]) {
		List<Card> deck = Card.getStandardDeck();
		Card.printDeck(deck);

		Card[] cardArray = new Card[13];
		Card aceOfHeart = Card.getFaceCard(SUITE.HEART, 'A');
		Arrays.fill(cardArray, aceOfHeart);
		System.out.println(Arrays.toString(cardArray));
		Card.printDeck(Arrays.asList(cardArray), "ACES OF HEARTS", 1);
		List<Card> cards = new ArrayList<>(52);
		Collections.fill(cards, aceOfHeart);
		System.out.println(cards);
		System.out.println(" card.size() " + cards.size());

		List<Card> nCopiesList = Collections.nCopies(13, aceOfHeart);
		System.out.println(nCopiesList);
		System.out.println(" nCopiesList.size() " + nCopiesList.size());

		Card kingOfClubs = Card.getFaceCard(SUITE.CLUB, 'K');
		List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
		Card.printDeck(kingsOfClubs, "King Of Clubs", 1);

		Collections.addAll(cards, cardArray);
		Card.printDeck(cards,"Card of Hearts",1);
		
		// Copy Method
		Collections.copy(cards, kingsOfClubs);
		Card.printDeck(cards, "Cards Hearts Collection with Kings Copied", 1);

	}
}
