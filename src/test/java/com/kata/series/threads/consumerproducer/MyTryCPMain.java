package com.kata.series.threads.consumerproducer;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Message {

	private String message;

	private boolean messageAvailable = true;

	public synchronized String read() {
		while (messageAvailable) {
			System.out.println("-");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notify();
		messageAvailable = true;
		return message;
	}

	public synchronized void write(String message) {
		while (!messageAvailable) {
			System.out.println("*");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		messageAvailable = false;
		this.message = message;
		notify();
	}
}

class Producer implements Runnable {
	private Message message;

	public Producer(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Text to Write ?");
		String text = sc.next();

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.getLocalizedMessage();
		}
		message.write(text);
	}
}

class Consumer implements Runnable {
	private Message message;

	public Consumer(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		System.out.println(message.read());
	}
}

public class MyTryCPMain {

	public static void main(String[] args) {
		Message message = new Message();

		Thread t1 = new Thread(new Producer(message));
		Thread t2 = new Thread(new Consumer(message));
		t1.start();
		t2.start();

	}

}
