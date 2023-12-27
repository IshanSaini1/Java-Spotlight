package com.kata.series.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.series.kafka.modules.entity.PaymentRequest;
import com.kata.series.kafka.modules.entity.PurchaseRequest;
import com.kata.series.kafka.modules.producers.PaymentRequestProducer;

@Service
public class PaymentRequestService {

	@Autowired
	private PaymentRequestProducer producer;

	public String sendPaymentRequests() throws Exception {

		PaymentRequest payRequestAlpha_transaction1 = new PaymentRequest("Pay-Alpha", 551, "USD", "Notes Alpha",
				"Budget Reserve");
		PaymentRequest payRequestAlpha_transaction2 = new PaymentRequest("Pay-Alpha", 551, "USD", "Notes Alpha",
				"Approval Workflow");
		PaymentRequest payRequestAlpha_transaction3 = new PaymentRequest("Pay-Alpha", 551, "USD", "Notes Alpha",
				"Push Notifications");

		PaymentRequest payRequestBeta_transaction1 = new PaymentRequest("Pay-Beta", 551, "USD", "Notes Beta",
				"Budget Reserve");
		PaymentRequest payRequestBeta_transaction2 = new PaymentRequest("Pay-Beta", 551, "USD", "Notes Beta",
				"Approval Workflow");
		PaymentRequest payRequestBeta_transaction3 = new PaymentRequest("Pay-Beta", 551, "USD", "Notes Beta",
				"Push Notifications");

		producer.sendMessage(payRequestAlpha_transaction1);
		producer.sendMessage(payRequestAlpha_transaction2);
		producer.sendMessage(payRequestAlpha_transaction3);
		producer.sendMessage(payRequestBeta_transaction1);
		producer.sendMessage(payRequestBeta_transaction2);
		producer.sendMessage(payRequestBeta_transaction3);
		

		producer.sendMessage(payRequestAlpha_transaction2);
		producer.sendMessage(payRequestBeta_transaction3);

		return " Messages Sent Successfully";

	}

}
