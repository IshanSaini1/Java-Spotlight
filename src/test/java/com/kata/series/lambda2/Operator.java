package com.kata.series.lambda2;

@FunctionalInterface
public interface Operator<T> {
	public T operate(T a, T b);
}
