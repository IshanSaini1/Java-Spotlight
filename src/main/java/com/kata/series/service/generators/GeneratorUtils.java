package com.kata.series.service.generators;

import java.util.List;

import com.kata.series.kafka.modules.entity.Commodity;

public interface GeneratorUtils {
	
	public List<String> generateNameList(int count);
	public List<Commodity> generateCommodity(int count);

}
