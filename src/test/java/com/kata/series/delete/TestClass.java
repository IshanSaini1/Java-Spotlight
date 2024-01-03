package com.kata.series.delete;

import java.util.Optional;
import java.util.function.ToIntBiFunction;

class test2{
	public int value;
	public int hashCode() {
		return (int)(value^5);
	}
}

public class TestClass {
	
	Runnable r = ()->{
		System.out.println("My Runnabel");
	};
	
	ToIntBiFunction<Integer, Integer> add = (a,b) -> a+b;
	
	public static void main(String args[]) throws ChildException {
		Optional<String> GOT = Optional.of("Game of Thrones");
		String[] str = new String[10];
		Optional<String> strOpt = Optional.ofNullable(str[9]);
		System.out.println(strOpt.isPresent());
		System.out.println();
		
		var h = InterfactTest.messUp();
		int s = new InterfactTest() {
		}.getSum(10, 11);
		System.out.println(h);
		System.out.println(s);
		
		throw new ChildException(new RuntimeException("Problem"));
	}
}
