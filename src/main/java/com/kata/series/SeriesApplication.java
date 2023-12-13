package com.kata.series;

import java.util.Arrays;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.kata.series.e1.Person;
import com.kata.series.e1.Vehicle;

@EnableAspectJAutoProxy
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareConfiguration")
public class SeriesApplication {

	public static void main(String[] args) {

		SpringApplication.run(SeriesApplication.class, args);

	}

	@Deprecated
	private static void method2(AnnotationConfigApplicationContext context) {
		int a = new Random().nextInt(0, 10);
		if (a % 2 == 0) {
			context.registerBean("Audi", Vehicle.class, () -> {
				Vehicle audi = new Vehicle();
				audi.setName("Audi V1");
				return audi;
			});
		} else {
			context.registerBean("Audi", Vehicle.class, () -> {
				Vehicle audi = new Vehicle();
				audi.setName("Audi V2");
				return audi;
			});
		}

		var au = context.getBean("Audi", Vehicle.class);
		System.out.println(au);

		// -----------------------------------------------//

		Person lucy = context.getBean("lucy", Person.class);
		System.out.println(lucy);
	}

	@Deprecated
	private static void method1(ApplicationContext context) {
		String[] listOfVehicleTypes = context.getBeanNamesForType(Vehicle.class);
		String beanName = (Arrays.stream(listOfVehicleTypes).findAny().isPresent())
				? Arrays.stream(listOfVehicleTypes).findAny().get()
				: null;
		System.out.println(beanName);
		Vehicle v2 = (Vehicle) context.getBean(beanName);
		String str1 = context.getBean(String.class);
		Integer int1 = (Integer) context.getBean("number");

		System.out.printf("Vehicle : %s  %n String Value : %s %n Integer Value : %d", v2, str1, int1);
	}

}
