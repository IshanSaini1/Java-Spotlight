package com.kata.series.threads.challenge1;

import java.time.LocalDateTime;

public class ChallengeMain {

	public static void main(String[] args) {
		Thread even = new EvenNumbers("Even Thread 0");
		Thread odd = new Thread(new OddNumbers("Odd Thread 0"));
		odd.setName("Odd Thread 0");
		even.start();
		odd.start();
		int now =  LocalDateTime.now().getSecond();
		
		Thread threadMonitor = new Thread(() -> {
			
			int secNow = LocalDateTime.now().getSecond();
			
			if (now - secNow > 5) {
				System.out.println("5 seconds complete for Even");
				even.interrupt();
			}

			if (now - secNow > 10) {
				System.out.println("10 seconds complete for Odd");
				odd.interrupt();
			}
			if (even.isInterrupted() && odd.isInterrupted()) {
				System.out.println(
						"Both even thread and odd thread are Interrupted and hence terminating thread monitor");
				Thread.currentThread().interrupt();
				Thread.yield();
			}
		}, "ThreadMonitor");
		threadMonitor.start();

	}

}
