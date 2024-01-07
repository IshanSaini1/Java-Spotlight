package com.kata.series.design_principles.SOLID.factory;

interface Wallet {
	public String displayBalance();

	public default int getId() {
		return 0;
	}
}

class PrimaryWallet implements Wallet {

	@Override
	public String displayBalance() {
		return "BALANCE = 10";
	}

}

class SecondaryWallet implements Wallet {

	@Override
	public String displayBalance() {
		return "Balance = 20";
	}

}

class WalletFactory {
	public static Wallet getWallet(Character c) {
		switch (c) {
		case 'p': {
			return new PrimaryWallet();
		}
		case 's': {
			return new SecondaryWallet();
		}
		default: {
			return new PrimaryWallet();
		}
		}
	}
}

public class FactoryPattern {

	public static void main(String...strings) {
		System.out.println(WalletFactory.getWallet('p').displayBalance());
		System.out.println(WalletFactory.getWallet('s').displayBalance());
	}
}
