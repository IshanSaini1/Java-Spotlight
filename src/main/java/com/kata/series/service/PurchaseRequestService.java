package com.kata.series.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.series.kafka.modules.entity.PurchaseRequest;
import com.kata.series.kafka.modules.producers.PurchaseRequestProducer;

@Service
public class PurchaseRequestService {

	@Autowired
	private PurchaseRequestProducer producer;

	public String sendPurchaseRequests() throws Exception {
		PurchaseRequest pr1 = new PurchaseRequest(5551, "PR-FIRST", 991, "USD");
		PurchaseRequest pr2 = new PurchaseRequest(5552, "PR-SECOND", 992, "USD");
		PurchaseRequest pr3 = new PurchaseRequest(5553, "PR-THIRD", 993, "USD");

		producer.sendMessage(pr1);
		producer.sendMessage(pr2);
		producer.sendMessage(pr3);

		producer.sendMessage(pr1);

		return " Messages Sent Successfully";

	}

}
