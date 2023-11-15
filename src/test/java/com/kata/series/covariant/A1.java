package com.kata.series.covariant;

public class A1 {
	int a;
	int b;

	public A1(int a, int b) {
		System.out.println("In A1");
		this.a = a;
		this.b = b;
	}

	void print() {
		System.out.println("Inside the class A1");
	}

	A1 foo() {
		return this;
	}
	
	A1 motamamba() {
		System.out.println("motamamba A1");
		return new A1(1,2);
	}

}