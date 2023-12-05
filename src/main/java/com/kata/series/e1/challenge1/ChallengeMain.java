package com.kata.series.e1.challenge1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kata.series.e1.challenge1.config.ChallengeConfiguration;
import com.kata.series.e1.challenge1.person.Person;
import com.kata.series.e1.challenge1.vehicle.VehicleService;

public class ChallengeMain {

	public static void main(String args[]) {
		var context = new AnnotationConfigApplicationContext(ChallengeConfiguration.class);
		Person person = context.getBean(Person.class);
		System.out.println("Person  : " + person.getName());
		System.out.println("Speaker : " + person.getVehicle().getVehicleService().getSpeaker().makeSound());
		System.out.println("Tyre : " + person.getVehicle().getVehicleService().getTyre().rotate());

		// Check the scope

		var vsBean1 = context.getBean(VehicleService.class);
		var vsBean2 = context.getBean(VehicleService.class);
		int bean1HC = vsBean1.hashCode();
		int bean2HC = vsBean2.hashCode();

		System.out.println(bean1HC == bean2HC);

	}
}
