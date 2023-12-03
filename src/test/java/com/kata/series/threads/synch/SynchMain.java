package com.kata.series.threads.synch;

public class SynchMain {

	public static void main(String... strings) {
		BankAccount companyAccount = new BankAccount(10000);
		Thread t1 = new Thread(() -> {
			companyAccount.withdraw(2500);
		});
		Thread t2 = new Thread(() -> {
			companyAccount.deposit(5000);
		});
		Thread t3 = new Thread(() -> {
			companyAccount.withdraw(2500);
		});
		t1.start();
		t2.start();
		t3.start();

		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException ie) {

		}
		
		System.out.println("FINAL BALANCE POST CHANGES : "+companyAccount.getBalance());

	}
}
