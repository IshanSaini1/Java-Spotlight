package com.kata.series.service.generators;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.kata.series.kafka.modules.entity.Commodity;

@Component
public class GeneratorUtilsImpl implements GeneratorUtils{

	@Override
	public List<String> generateNameList(int count) {
		var x = Stream.generate(()->new NameSupplier().get()).limit(count).collect(Collectors.toList());
		x.forEach(System.out::println);
		return x;
	}

	@Override
	public List<Commodity> generateCommodity(int count) {
		// TODO Auto-generated method stub
		return null;
	}

}
