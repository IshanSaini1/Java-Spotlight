package com.kata.series.lambda;

@FunctionalInterface
public interface Operation<T> {

	public T operate(T value1, T value2);
}
