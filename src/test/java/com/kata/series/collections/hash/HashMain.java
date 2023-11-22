package com.kata.series.collections.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashMain {

	public static void main(String[] args) {
		String aText = "Hello";
		String bText = "Hello";
		String cText = String.join("l", "He", "lo");
		String dText = "He".concat("llo");
		String eText = "hello";
		String fText = new String("Hello");
		List<String> hellos = new ArrayList<>(List.of(aText, bText, cText, dText, eText));
		hellos.forEach(x -> System.out.println(x + "  " + "  hashCode : " + x.hashCode()));
		System.out.println(aText == bText);
		System.out.println(aText == cText);
		System.out.println(aText == dText);
		System.out.println(aText == eText);
		System.out.println(aText == fText.intern());
		System.out.println(aText.intern() == cText.intern());
		System.out.println("-----------------");
		System.out.println("-----------------");
		Set<String> mySet = new HashSet<>(hellos);
		System.out.println("my Set = " + mySet);
		System.out.println("Elements in my set = " + mySet.size());
		System.out.println("-------------------");
		PlayingCard aceHearts = new PlayingCard("Hearts", "Ace");
		PlayingCard kingClubs = new PlayingCard("Club", "King");
		PlayingCard queenSpades = new PlayingCard("Spades", "Queen");
		List<PlayingCard> listOfCards = new ArrayList<>(List.of(aceHearts, kingClubs, queenSpades));
		listOfCards.forEach(x -> System.out.println("Hash code for " + x + " is " + x.hashCode()));
		System.out.println("------------");
		Set<PlayingCard> deck = new HashSet<>();
		for(PlayingCard c : listOfCards) {
			if(!deck.add(c)) {
				System.out.println("Duplicate value for "+c);
			}
		}
		System.out.println(deck);
	
	}

}
