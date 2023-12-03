package com.kata.series.threads;

import java.util.concurrent.TimeUnit;

public class ThreadMain2 {

	public static void main(String[] args) {
		System.out.println("Main thread running");
		try {
			System.out.println("Main thread is paused for 1 second");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Thread t1 = new Thread(() -> {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " : Should take 10 dots to end");
			for (int i = 0; i < 10; i++) {
				System.out.print(".");
				try {
					TimeUnit.MILLISECONDS.sleep(500);
					System.out.println("A1. state of thread t1 : " + Thread.currentThread().getState());
				} catch (InterruptedException e) {
					System.out.println("\nInterrupted Exception Thread : t1");
					System.out.println("A2. state of thread t1 : " + Thread.currentThread().getState());
					Thread.currentThread().interrupt();
					e.printStackTrace();
					return;
				}
			}
			System.out.println("\nThread  :" + threadName + " Completed its Execution.");
		});

		Thread installThread = new Thread(() -> {
			try {
				for (int i = 0; i < 3; i++) {
					Thread.sleep(250);
					System.out.println("Installation Step " + (i + 1) + " is Completed");
				}
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

		}, "InstallThread");

		long now = System.currentTimeMillis();

		Thread threadMonitor = new Thread(() -> {

			while (t1.isAlive()) {
				try {
					Thread.sleep(1000);
					System.out.println("B. State = " + t1.getState());
					if (System.currentTimeMillis() - now > 2000) {
						t1.interrupt();
					}
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		});

		System.out.println(" Starting ");
		t1.start();
		threadMonitor.start();

		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!t1.isInterrupted()) {
			installThread.start();
		} else {
			System.out.println("Thissshit cant run ");
		}

	}

}
