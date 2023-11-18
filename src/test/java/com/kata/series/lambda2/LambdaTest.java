package com.kata.series.lambda2;

public class LambdaTest {

	public static void main(String... args) {

		Integer result1 = OperationService.calculator((x, y) -> x + y, 3, 5);
		String result2 = OperationService.calculator((x, y) -> x + y, "Ishan ", "Saini");
		Integer result3 = OperationService.calculator((Integer a, Integer b) -> a + b, 5, 6);
		Double result4 = OperationService.calculator((a, b) -> a / b, 10.0, 20d);
		Integer result5 = OperationService.calculator((Integer x, Integer y) -> { 
			return Integer.sum(x, y);
		}, 5, 6);
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);
	}
}
