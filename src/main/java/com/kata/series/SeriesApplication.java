package com.kata.series;

import java.util.Arrays;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kata.series.config.ProjConfig;
import com.kata.series.e1.Person;
import com.kata.series.e1.Vehicle;

public class SeriesApplication {

	public static void main(String[] args) {
		Vehicle v1 = new Vehicle();
		v1.setName("Honda City V1");
		System.out.println("NON SPRING IOC CONTEXT : " + v1);

		var context = new AnnotationConfigApplicationContext(ProjConfig.class);
		
		Person p = context.getBean(Person.class);
		System.out.println(p);
		

		// method2(context);

		// method1(context);

		// SpringApplication.run(SeriesApplication.class, args);
	}

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

		Person lucy = context.getBean("lucy",Person.class);
		System.out.println(lucy);
	}

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
