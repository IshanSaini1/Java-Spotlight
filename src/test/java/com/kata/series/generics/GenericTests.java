package com.kata.series.generics;

import org.junit.jupiter.api.Test;

public class GenericTests {

	public interface Player {

	}

	public record BaseballPlayer(String name, String position) implements Player {

	}
	
	public record FootballPlayer(String name, String position) implements Player {

	}

	@Test
	public void genericMainTest() {
		BaseballTeam phillies1 = new BaseballTeam("Philladelphia Phillies");
		BaseballTeam hustonAstros1 = new BaseballTeam("Huston Astros");
		scoreResults(phillies1, 3, hustonAstros1, 5);

		SportsTeam phillies = new SportsTeam("Philladelphia Phillies");
		SportsTeam hustonAstros = new SportsTeam("Huston Astros");
		scoreResults(phillies, 3, hustonAstros, 5);

		var harper = new BaseballPlayer("B Harper", "Right Fielder");
		var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
		phillies.addTeamMember(harper);
		phillies.addTeamMember(marsh);
		phillies.listTeamMembers();

		SportsTeam afc = new SportsTeam("Adelaide Crows Team");
		var tex = new FootballPlayer("Tex Walker", "Center Half Forward");
		afc.listTeamMembers();
	}

	public static void scoreResults(BaseballTeam t1, int t1_score, BaseballTeam t2, int t2_score) {
		String message = t1.setScore(t1_score, t2_score);
		t2.setScore(t2_score, t1_score);
		System.out.printf("%s %s %s %n", t1, message, t2);
	}		

	public static void scoreResults(SportsTeam t1, int t1_score, SportsTeam t2, int t2_score) {
		String message = t1.setScore(t1_score, t2_score);
		t2.setScore(t2_score, t1_score);
		System.out.printf("%s %s %s %n", t1, message, t2);
	}

}
