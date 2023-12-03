package com.kata.series.threads;

import java.util.concurrent.TimeUnit;

public class RunnableTest implements Runnable{
	
	String printNumber;
	
	public RunnableTest(String printNumber) {
		this.printNumber = printNumber;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(printNumber);
			try {
				TimeUnit.MILLISECONDS.sleep(250);
			} catch (InterruptedException e) {
				System.out.println("Thread " + Thread.currentThread().getName() + " : " + "was interrupted");
			}
		}
	}

}
