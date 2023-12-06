package com.kata.series.e1.aspects;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kata.series.e1.aspects.aspect_config.AspectConfig;
import com.kata.series.e1.aspects.objects.Student;

public class AspectMainClass {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(AspectConfig.class);
		var studentDefault = context.getBean(Student.class);
		System.out.println("\nStudent Name : " + studentDefault.getName() + " \nDivision : "
				+ studentDefault.getDivision().getDiv_class());

		System.out.println(studentDefault.sayHello());

		System.out.println(studentDefault.sayImportantMessage());
	}

}
