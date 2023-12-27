package com.kata.series.kafka.modules.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRequest {
	private int id;
	private String prNumber;
	private int amount;
	private String currency;
}
