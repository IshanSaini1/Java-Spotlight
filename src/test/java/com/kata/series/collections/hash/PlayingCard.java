package com.kata.series.collections.hash;

import java.util.Objects;

public class PlayingCard {

	private String suit;
	private String face;

	private int internalHash;

	public PlayingCard(String suit, String face) {
		this.suit = suit;
		this.face = face;
		this.internalHash = (suit.equals("Hearts")) ? 11 : 12;
	}

	@Override
	public String toString() {
		return "PlayingCard [suit=" + suit + ", face=" + face + ", internalHash=" + internalHash + "]";
	} 

	@Override
	public int hashCode() {
		int result = suit.hashCode();
		result = 31 * result + face.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayingCard other = (PlayingCard) obj;
		return Objects.equals(face, other.face) && internalHash == other.internalHash
				&& Objects.equals(suit, other.suit);
	}

}
