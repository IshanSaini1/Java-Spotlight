package com.kata.series.kafka.modules.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
	private String invoiceNumber;
	private int amount;
	private String currency;
}
