package com.kata.series.covariant;

public class A3 extends A2 {

	int z;
	A2 a2;
	A2 a21;

	public A3(int x, int y, int a, int b, int z) {
		super(x, y, a, b);
		A2 a2 = super.foo();
		A2 a21 = super.foo2();
		this.a2 = a2;
		this.a21 = a21;
		System.out.println("In A3");
		this.z = z;

		System.out.println(x + y + a + b + z);
	}

	void print() {
		System.out.println("Inside the class A3");
	}

}