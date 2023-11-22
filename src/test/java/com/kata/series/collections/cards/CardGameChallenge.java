package com.kata.series.collections.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardGameChallenge {
	public static void main(String args[]) {

		List<Card> player1 = new ArrayList<>();
		List<Card> player2 = new ArrayList<>();
		List<Card> player3 = new ArrayList<>();
		List<Card> player4 = new ArrayList<>();

		List<Card> deck = Card.getStandardDeck();
		dealCardsToPlayer(deck, player1);
		dealCardsToPlayer(deck, player2);
		dealCardsToPlayer(deck, player3);
		dealCardsToPlayer(deck, player4);

		Card.printDeck(player1, "Player 1 Deck", 1);
		Card.printDeck(player2, "Player 2 Deck", 1);
		Card.printDeck(player3, "Player 3 Deck", 1);
		Card.printDeck(player4, "Player 4 Deck", 1);

		Integer acePlayer1 = numberOfAsInHand(player1);
		Integer acePlayer2 = numberOfAsInHand(player2);
		Integer acePlayer3 = numberOfAsInHand(player3);
		Integer acePlayer4 = numberOfAsInHand(player4);
		List<Integer> listOfAces = List.of(acePlayer1, acePlayer2, acePlayer3, acePlayer4);
		Integer greatestAces = Collections.max(listOfAces);

		switch (listOfAces.indexOf(greatestAces)) {
		case 0 -> System.out.println("Player 1 wins");
		case 1 -> System.out.println("Player 2 wins");
		case 2 -> System.out.println("Player 3 wins");
		case 3 -> System.out.println("Player 4 wins");
		default -> System.out.println("No Idea Who Won !!");
		}
	}

	public static void dealCardsToPlayer(List<Card> allCards, List<Card> playerCardList) {
		for (int i = 0; i < 13; i++) {
			Collections.shuffle(allCards);
			playerCardList.add(allCards.get(0));
			allCards.remove(0);
		}
	}

	public static Integer numberOfAsInHand(List<Card> deck) {
		Integer count = 0;
		for (int i = 0; i < deck.size(); i++) {
			if (deck.get(i).face.equals('A')) {
				count++;
			}
		}
		return count;

	}

}
