package com.kata.series.e1.aspects.aspect_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.kata.series.e1.aspects.objects.Division;

@Configuration
@ComponentScan(basePackages = { "com.kata.series.e1.aspects" })
@EnableAspectJAutoProxy
public class AspectConfig {

	@Bean(name = "DIV10")
	Division division10() {
		return new Division("X", 10);
	}

	@Bean(name = "DIV11")
	Division division11() {
		return new Division("XI", 11);
	}

	@Bean(name = "DIV12")
	Division division12() {
		return new Division("XII", 12);
	}

}
