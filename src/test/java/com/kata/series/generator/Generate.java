package com.kata.series.generator;

import java.util.List;
import java.util.Random;

public interface Generate<T extends Object> {
	final Random RAND = new Random();

	T generateData(T item ,String... args);
	List<T> generateRandomList(List<T> list);
	

}
