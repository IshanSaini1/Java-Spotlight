package com.kata.series.collections.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CardCollectionMain2 {

	public static void main(String args[]) {
		List<Card> cardList = Card.getStandardDeck();
		Card.printDeck(cardList);
		Collections.shuffle(cardList);
		Card.printDeck(cardList);
		Collections.reverse(cardList);
		Card.printDeck(cardList);

		Comparator<Card> sortingAlgorithm = Comparator.comparing(Card::getRank);
		Collections.sort(cardList, sortingAlgorithm.reversed().thenComparing(Card::getSuite));
		Card.printDeck(cardList, "Sorted By Comparator", 13);

		List<Card> kings = new ArrayList<>(cardList.subList(4, 8));
		Card.printDeck(kings, "Deck of Kings", 1);

		List<Card> tens = new ArrayList<>(cardList.subList(16, 20));
		Card.printDeck(tens, "Deck of 10's", 1);

		int subListFirstIndex = Collections.indexOfSubList(cardList, tens);
		int subListLastIndex = Collections.lastIndexOfSubList(kings, tens);
		System.out.println(subListFirstIndex + "   " + subListLastIndex);
		System.out.println(Collections.disjoint(tens, cardList));
		System.out.println(Collections.disjoint(kings, tens));

		cardList.sort(sortingAlgorithm);
		Card tenOfHearts = Card.getNumberiCard(SUITE.HEART, 10);
		// System.out.println("Index of tens of hearts found at : " +
		// Card.getStandardDeck().indexOf(tenOfHearts) (tenOfHearts));
		int foundIndex = Collections.binarySearch(cardList, tenOfHearts, sortingAlgorithm);
		Card tensOfClub = Card.getNumberiCard(SUITE.CLUB, 10);
		System.out.println("item found at  cardList[" + foundIndex + "] is " + cardList.get(foundIndex));

		///////// New try at Replacing
		List<Integer> listOfIntegers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 6, 6, 6, 7, 8, 9, 10));
		listOfIntegers.forEach(x -> System.out.print(" " + x + " "));
		System.out.println();
		Collections.replaceAll(listOfIntegers, 5, 555);
		listOfIntegers.forEach(x -> System.out.print(" " + x + " "));
		System.out.println();
		System.out.println("---------------------");
		System.out.print(Collections.frequency(listOfIntegers, 6));

	}
}
