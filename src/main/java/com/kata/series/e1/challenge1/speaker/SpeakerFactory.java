package com.kata.series.e1.challenge1.speaker;

public class SpeakerFactory {

	public static Speaker getSpeaker(int speakerNumber) {
		switch (speakerNumber) {
		case 0:
			return new SonySpeaker();
		case 1:
			return new BoseSpeaker();
		default:
			return new SonySpeaker();
		}
	}
}
