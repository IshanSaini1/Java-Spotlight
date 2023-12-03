package com.kata.series.threads;

public class CustomThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("1");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Thread " + currentThread().getName() + " : " + "was interrupted");
			}
		}
	}

}
