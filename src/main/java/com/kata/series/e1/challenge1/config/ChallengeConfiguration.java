package com.kata.series.e1.challenge1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;

@Profile("NO_BOOT")
@Configuration
@ComponentScan(basePackages = { "com.kata.series.e1.challenge1" })
public class ChallengeConfiguration {
	

}
