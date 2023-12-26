package com.kata.series.kafka.modules.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class Commodity {
	@Setter
	private String name;
	private Double price;
	@Setter
	private String measurement;
	@Setter
	private LocalDate localDate;
	
	
	
	public void setPrice(Double price) {
		var d = BigDecimal.valueOf(price).setScale(2, RoundingMode.FLOOR);
		this.price = d.doubleValue();
	}



	public Commodity(String name, Double price, String measurement, LocalDate localDate) {
		this.name = name;
		this.price = BigDecimal.valueOf(price).setScale(2, RoundingMode.FLOOR).doubleValue();
		this.measurement = measurement;
		this.localDate = localDate;
	}
}
