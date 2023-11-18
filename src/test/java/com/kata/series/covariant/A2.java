package com.kata.series.covariant;

public class A2 extends A1 {

	int a, b;

	public A2(int x, int y, int a, int b) {
		super(x, y);
		System.out.println("In A2");
		this.a = a;
		this.b = b;
	}

	void print() {
		System.out.println("Inside the class A2");
	}

	public A2 foo() {
		return this;
	}

	public A2 foo2() {
		return new A2(3, 2, 2, 1);
	}

	A2 motamamba() {
		System.out.println("motamamba 30, 40");
		return new A2(10, 20, 30, 40);
	}

}