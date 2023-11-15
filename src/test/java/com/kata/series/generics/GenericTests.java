package com.kata.series.generics;

import org.junit.jupiter.api.Test;

public class GenericTests {

	public record BaseballPlayer(String name, String position) {

	}

	@Test
	public void genericMainTest() {
		BaseballTeam phillies = new BaseballTeam("Philladelphia Phillies");
		BaseballTeam hustonAstros = new BaseballTeam("Huston Astros");
		scoreResults(phillies, 3, hustonAstros, 5);

		var harper = new BaseballPlayer("B Harper", "Right Fielder");
		var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
		phillies.addTeamMember(harper);
		phillies.addTeamMember(marsh);
		phillies.listTeamMembers();
	}

	public static void scoreResults(BaseballTeam t1, int t1_score, BaseballTeam t2, int t2_score) {
		String message = t1.setScore(t1_score, t2_score);
		t2.setScore(t2_score, t1_score);
		System.out.printf("%s %s %s %n", t1, message, t2);
	}

}
