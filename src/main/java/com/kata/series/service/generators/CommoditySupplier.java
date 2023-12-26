package com.kata.series.service.generators;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Component;

import com.kata.series.kafka.modules.entity.Commodity;

@Component
public class CommoditySupplier implements Supplier<Map<String, Commodity>> {

	private String[] listOfCommodityNames = { "GOLD", "SILVER", "DIAMOND", "BRASS", "ALUMINUM", "CRUDE-OIL" };

	private static final double MAX_ADJUSTMENT = 1.06d;
	private static final double MIN_ADJUSTMENT = 0.95d;

	private static final String OUNCE = "OUNCE";
	private static final String TONNE = "TONNE";

	private Map<String, Commodity> generateCommodity() {
		Map<String, Commodity> map = new HashMap<>();
		for (String commodity : listOfCommodityNames) {
			double price = RandomUtils.nextDouble(MIN_ADJUSTMENT, MAX_ADJUSTMENT);
			String measurement = (RandomUtils.nextInt(1, 11) % 2 == 0) ? OUNCE : TONNE;
			map.put(commodity, new Commodity(commodity, price, measurement, LocalDate.now()));
		}
		return map;
	}

	@Override
	public Map<String, Commodity> get() {
		return generateCommodity();
	}

}
