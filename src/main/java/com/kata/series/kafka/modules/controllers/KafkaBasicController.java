package com.kata.series.kafka.modules.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kata.series.kafka.modules.entity.Commodity;
import com.kata.series.kafka.modules.entity.Employee;
import com.kata.series.kafka.modules.entity.FoodOrder;
import com.kata.series.kafka.modules.entity.SimpleNumber;
import com.kata.series.kafka.modules.producers.EmployeeProducer;
import com.kata.series.kafka.modules.producers.FoodOrderProducer;
import com.kata.series.kafka.modules.producers.HelloKafkaProducer;
import com.kata.series.kafka.modules.producers.InvoiceProducer;
import com.kata.series.kafka.modules.producers.KafkaKeyProducer;
import com.kata.series.kafka.modules.producers.SimpleNumberProducer;
import com.kata.series.service.ImageService;
import com.kata.series.service.InvoiceService;
import com.kata.series.service.PaymentRequestService;
import com.kata.series.service.PurchaseRequestService;
import com.kata.series.service.generators.CommoditySupplier;
import com.kata.series.service.generators.GeneratorUtils;
import com.kata.series.service.generators.NameSupplier;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/kafka")
public class KafkaBasicController {

	@Autowired
	private InvoiceService invoiceService;

	@Autowired
	private HelloKafkaProducer producer;

	@Autowired
	private KafkaKeyProducer keyProducer;

	@Autowired
	private EmployeeProducer employeeProducer;

	@Autowired
	private FoodOrderProducer foodOrderProducer;

	@Autowired
	GeneratorUtils generateUtils;

	@Autowired
	NameSupplier nameSupplier;

	@Autowired
	CommoditySupplier commoditySupplier;

	@Autowired
	PurchaseRequestService purchaseRequestService;

	@Autowired
	PaymentRequestService paymentRequestService;

	@Autowired
	SimpleNumberProducer simpleNumberProducer;

	@Autowired
	ImageService imageService;

	@Autowired
	InvoiceProducer invoiceProducer;

	@GetMapping("/msg-1")
	public String sendKafkaMessage(@RequestParam("name") String name, HttpServletRequest request, HttpSession session) {
		String source = request.getHeader("invoked-from");
		log.info("So urce : " + source + " by " + name);
		producer.sendHello(name);
		log.info("Message sent to kafka");
		return name;
	}

	@GetMapping("/msg-2")
	public String sendKafkaMessage(HttpServletRequest request, HttpSession session) throws InterruptedException {
		String source = request.getHeader("invoked-from");
		for (int i = 0; i < 30; i++) {
			String key = "key-" + (i % 4);
			String value = "value " + i + " with Key " + key;
			keyProducer.send(key, value);
			log.info(" Key : {} ; value : {}", key, value);
			TimeUnit.SECONDS.sleep(1);
		}
		return "success from " + source;
	}

	@GetMapping("/emp-1")
	public String sendEmployeeToKafka() throws JsonProcessingException {
		AtomicInteger id = new AtomicInteger(0);
		String runId = nameSupplier.get();
		List<String> names = generateUtils.generateNameList(5);
		for (String name : names) {
			Integer getId = id.addAndGet(1);
			Employee emp = new Employee("id-" + runId + "-" + getId, name, LocalDate.now());
			employeeProducer.sendMessage(emp);
		}
		return "messages sent successfully";
	}

	@GetMapping(path = "/commodity", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Commodity> sendCommodityToKafka() {
		var map = commoditySupplier.get();
		var x = map.entrySet().stream().map(t -> t.getValue()).collect(Collectors.toList());
		return x;
	}

	@GetMapping("/purchase-request")
	public ResponseEntity<String> sendPurchaseRequests() throws Exception {
		String val = purchaseRequestService.sendPurchaseRequests();
		return ResponseEntity.status(HttpStatus.OK).body(val);
	}

	@GetMapping("/payment-request")
	public ResponseEntity<String> sendPaymentRequests() throws Exception {
		String val = paymentRequestService.sendPaymentRequests();
		return ResponseEntity.status(HttpStatus.OK).body(val);
	}

	@GetMapping("/food-order")
	public ResponseEntity<String> sendFoodOrder() throws JsonProcessingException {
		FoodOrder chicken = new FoodOrder(3, "Chicken");
		FoodOrder fish = new FoodOrder(10, "Fish");
		FoodOrder pizza = new FoodOrder(5, "Pizza");

		foodOrderProducer.send(chicken);
		foodOrderProducer.send(fish);
		foodOrderProducer.send(pizza);

		return ResponseEntity.status(HttpStatus.OK).body("Message Sent to Kafka");
	}

	@GetMapping("/food-order-global")
	public ResponseEntity<String> sendFoodOrderGlabal() throws JsonProcessingException {
		FoodOrder chicken = new FoodOrder(3, "Chicken");
		FoodOrder fish = new FoodOrder(10, "Fish");
		FoodOrder pizza = new FoodOrder(5, "Pizza");

		foodOrderProducer.send(chicken);
		foodOrderProducer.send(fish);
		foodOrderProducer.send(pizza);

		for (int i = 0; i < 3; i++) {
			simpleNumberProducer.sendSimpleNumber(new SimpleNumber(i));
		}

		return ResponseEntity.status(HttpStatus.OK).body("Message Sent to Kafka");
	}

	@GetMapping("/img1")
	public ResponseEntity<String> sendImages() throws JsonProcessingException {
		var img1 = imageService.generateImage("jpg");
		var img2 = imageService.generateImage("svg");
		var img3 = imageService.generateImage("png");
		var img4 = imageService.generateImage("gif");
		var img5 = imageService.generateImage("bmp");
		var img6 = imageService.generateImage("tiff");

		imageService.sendImage(img1, 0);
		imageService.sendImage(img2, 0);
		imageService.sendImage(img3, 0);

		imageService.sendImage(img4, 1);
		imageService.sendImage(img5, 1);
		imageService.sendImage(img6, 1);

		return ResponseEntity.status(HttpStatus.OK).body("Images have been sent");

	}

	@GetMapping("/invoices-1")
	public ResponseEntity<String> sendInvoices() throws JsonProcessingException {
		for (int i = 0; i < 10; i++) {
			var invoice = invoiceService.generateInvoice();
			if (i > 5) {
				invoice.setAmount(0);
			}
			invoiceProducer.send(invoice);
		}
		return ResponseEntity.status(HttpStatus.OK).body("The invoices have been sent.");

	}
}
