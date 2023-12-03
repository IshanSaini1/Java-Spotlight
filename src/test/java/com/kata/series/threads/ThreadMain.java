package com.kata.series.threads;

import java.util.concurrent.TimeUnit;

public class ThreadMain {

	public static void main(String[] args) {
		var thread = Thread.currentThread();
		printThreadState(thread);
		thread.setName("Ishan Thread");
		thread.setPriority(Thread.MAX_PRIORITY);
		printThreadState(thread);

		CustomThread customThread = new CustomThread();
		customThread.start();

		Thread customThread2 = new Thread(() -> {
			for (int i = 0; i < 8; i++) {
				System.out.println("2");
				try {
					TimeUnit.MILLISECONDS.sleep(250);
				} catch (InterruptedException e) {
					System.out.println("Thread " + Thread.currentThread().getName() + " : " + "was interrupted");
				}
			}
		});
		customThread2.start();

		Thread customThread3 = new Thread(new RunnableTest("10"));
		customThread3.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("0");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				System.out.println("Thread " + Thread.currentThread().getName() + " : " + "was interrupted");
			}
		}
	}

	public static void printThreadState(Thread thread) {
		System.out.println("-".repeat(30));
		System.out.println("Thread Id : " + thread.getId());
		System.out.println("Thread Name : " + thread.getName());
		System.out.println("Thread Priority : " + thread.getPriority());
		System.out.println("Thread State : " + thread.getState());
		System.out.println("Thread Group : " + thread.getThreadGroup());
		System.out.println("Thread is Alive ? : " + thread.isAlive());
		System.out.println("Thread is Daemon ? :" + thread.isDaemon());
		System.out.println("-".repeat(30));
	}

}
