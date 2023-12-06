package com.kata.series.challenges;

import java.util.Scanner;

public class FibonacciMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number till when the Fibonacci Series is needed ? ");
		int tillWhen = sc.nextInt();
		int next = 1;
		int prev = 0;
		System.out.print(" " + prev + " ");
		for (int i = 1; i <= tillWhen; i++) {
			System.out.print(" " + next + " ");
			int temp = next;
			next = next + prev;
			prev = temp;
			System.out.print("");

		}
	}

}
