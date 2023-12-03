package com.kata.series.threads.challenge1;

public class OddNumbers implements Runnable {

	String THREAD_NAME = Thread.currentThread().getName();

	public OddNumbers(String name) {
		Thread.currentThread().setName(name);
	}

	@Override
	public void run() {
		int k = 0;

		System.out.println("Starting : " + THREAD_NAME);
		try {
			while (k < 1000) {
				int num = (2 * k) + 1;
				System.out.println("Processing " + THREAD_NAME + " : " + num);
				k++;
				Thread.sleep(1000);
			}
			System.out.println("Ending : " + THREAD_NAME);
		} catch (InterruptedException ie) {
			System.out.println("Ending with Interruption : " + THREAD_NAME);
			Thread.currentThread().interrupt();
		}
	}

}
