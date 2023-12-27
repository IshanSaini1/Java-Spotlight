package com.kata.series.kafka.modules.cache.keys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class PaymentRequestCacheKeys {
	private String paymentNumber;
	private int amount;
	private String transactionType;
}
