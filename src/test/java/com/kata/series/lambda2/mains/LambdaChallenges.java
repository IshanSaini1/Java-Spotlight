package com.kata.series.lambda2.mains;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LambdaChallenges {

	public static void main(String args[]) {
		Consumer<String> printTheParts = (String s) -> {
			Arrays.stream(s.split(" ")).forEach(x -> System.out.println(x));
		};
		printTheParts.accept("Hello World");

		UnaryOperator<String> ops1 = (source) -> {
			StringBuilder returnVal = new StringBuilder();
			for (int i = 0; i < source.length(); i++) {
				returnVal.append(source.charAt(i) + "i");
			}
			return returnVal.toString();
		};

		Function<String, StringBuilder> func = (source) -> {
			StringBuilder returnVal = new StringBuilder();
			for (int i = 0; i < source.length(); i++) {
				returnVal.append(source.charAt(i) + "i");
			}
			return returnVal;
		};

		String ops1Var = ops1.apply("Hello World");
		StringBuilder ops1Builder = func.apply("Hello World");
		System.out.println(ops1Var);
		System.out.println(ops1Builder);
		System.out.println("------------");

		System.out.println(everySecondCharacter((source) -> {
			StringBuilder returnVal = new StringBuilder();
			for (int i = 0; i < source.length(); i++) {
				returnVal.append(source.charAt(i) + "i");
			}
			return returnVal.toString();
		}, "Hello World 2"));

		System.out.println("-----*******------");

		Supplier<String> supply = () -> "I Love Java";
		String s1 = supply.get();
		System.out.println(s1);

	}

	public static <T> T everySecondCharacter(UnaryOperator<T> op, T word) {
		T result = op.apply(word);
		return result;
	}
}
