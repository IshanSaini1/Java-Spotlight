package com.kata.series.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.kata.series.kafka.modules.entity.Invoice;

import io.netty.util.internal.ThreadLocalRandom;

@Service
public class InvoiceService {
	private AtomicInteger counter = new AtomicInteger();
	
	public Invoice generateInvoice() {
		String invoiceNumber = counter.incrementAndGet()+"";
		var amount = ThreadLocalRandom.current().nextInt(1, 1000);
		return new Invoice(invoiceNumber, amount, "USD");
	}
}
