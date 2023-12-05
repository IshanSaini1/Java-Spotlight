package com.kata.series.threads.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import org.springframework.web.bind.annotation.RestController;

import com.kata.series.threads.ThreadColor;

class ColorThreadFactory implements ThreadFactory {

	private String threadName;

	public ColorThreadFactory(ThreadColor color) {
		this.threadName = color.name();
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setName(threadName);
		return thread;
	}

}

public class ExecutorMain {

	public static void main(String[] args) {

		Thread blue = new Thread(() -> {
			countDown();
		}, ThreadColor.ANSI_BLUE.name());

		Thread yellow = new Thread(() -> {
			countDown();
		}, ThreadColor.ANSI_YELLOW.name());

		Thread red = new Thread(() -> {
			countDown();
		}, ThreadColor.ANSI_RED.name());

		// Thread t1 = new ColorThreadFactory(ThreadColor.ANSI_BLUE).newThread(() ->
		// countDown());

		/*
		 * blue.start(); yellow.start(); red.start();
		 */

		ExecutorService exec = Executors.newSingleThreadExecutor(new ColorThreadFactory(ThreadColor.ANSI_BLUE));
		ExecutorService exec1 = Executors.newSingleThreadExecutor(new ColorThreadFactory(ThreadColor.ANSI_PURPLE));
		ExecutorService exec2 = Executors.newSingleThreadExecutor(new ColorThreadFactory(ThreadColor.ANSI_GREEN));

		exec.execute(blue);
		exec1.execute(red);
		exec2.execute(yellow);

		exec.shutdown();
		exec1.shutdown();
		exec2.shutdown();

	}

	public static void countDown() {
		String threadName = Thread.currentThread().getName();
		ThreadColor color = ThreadColor.ANSI_RESET;
		try {
			color = ThreadColor.valueOf(threadName.toUpperCase());
		} catch (Exception e) {
			System.out.println("BAD COLOR");
		}
		String tcolor = color.color();
		for (int i = 20; i >= 0; i--) {
			System.out.println(tcolor + "  " + threadName.replace("ANSI_", "") + " " + i);
		}
	}

}
