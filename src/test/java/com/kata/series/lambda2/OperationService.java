package com.kata.series.lambda2;

import java.util.function.BinaryOperator;

public class OperationService<T> {

	public static <T> T calculator(BinaryOperator<T> operator, T value1, T value2) {
		T result = operator.apply(value1, value2);
		return result;
	}

}
