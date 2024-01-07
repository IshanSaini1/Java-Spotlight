package com.kata.series.design_principles.SOLID.singleton;

import java.util.concurrent.Semaphore;

class Singleton {
	private static volatile Singleton INSTANCE;

	private Singleton() {

	}

	public static Singleton getInstance() throws InterruptedException {
		Semaphore semaphore = new Semaphore(5);
		if(semaphore.tryAcquire()) {
			semaphore.acquire();
		}
		if (null == INSTANCE) {
			INSTANCE = new Singleton();
		}
		semaphore.release();
		return INSTANCE;
	}

}

public class SingletonTest {
	public static void main(String... args) throws InterruptedException {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();

		System.out.println(s1 == s2);

	}
}
