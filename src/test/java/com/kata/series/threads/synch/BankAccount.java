package com.kata.series.threads.synch;

public class BankAccount {

	private double balance;

	public BankAccount(double balance) {
		super();
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public synchronized void deposit(double amount) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		double origBalance = balance;
		balance += amount;
		System.out.printf("%nStarting Balance : %.0f , Deposit of : %.0f  =" + " new Balance (%.0f %n)", origBalance,
				amount, balance);
	}

	public synchronized void withdraw(double amount) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		double origBalance = balance;
		if (balance <= amount) {
			System.out.printf("Balance is less than withdaraw amount BALANCE : = %.0f, WITHDRAWAL AMOUNT : %.0f",
					balance, amount);
		} else {
			balance -= amount;
			System.out.printf("%nStarting Balance : %.0f , Withdraw of : %.0f  =" + " new Balance (%.0f %n)",
					origBalance, amount, balance);
		}
	}

}
