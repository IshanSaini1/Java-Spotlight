package com.kata.series.kafka.modules.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString()
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrder {
	private int amount;
	private String item;
}
