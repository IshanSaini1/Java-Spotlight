package com.kata.series.generics;

import java.util.ArrayList;
import java.util.List;

import com.kata.series.generics.GenericTests.Player;

public class SportsTeam {

	private String teamName;
	private List<Player> teamMembers = new ArrayList<>();
	private int totalWins = 0;
	private int totalLosses = 0;
	private int totalTies = 0;

	public SportsTeam(String teamName) {
		this.teamName = teamName;
	}

	public void addTeamMember(Player player) {
		if (!teamMembers.contains(player)) {
			teamMembers.add(player);
		}
	}

	public void listTeamMembers() {
		System.out.println(String.format("Roaster for %s : ", teamName));
		for (Player player : teamMembers) {
			System.out.println(player);
		}
	}

	public int calculateRanking() {
		return (totalLosses * 2) + totalTies + 1;
	}

	public String setScore(int ourScore, int theirScore) {
		String message = " Lost to ";
		if (ourScore > theirScore) {
			totalWins++;
			message = " Beat ";
		} else if (ourScore == theirScore) {
			totalTies++;
			message = " Tie ";
		} else {
			totalLosses++;
		}
		return message;
	}

	@Override
	public String toString() {
		return String.format(" %s ranked %d  ", teamName, calculateRanking());
	}

}
