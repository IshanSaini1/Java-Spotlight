package com.kata.series.separate.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class ProjectConfiguration {

	@Bean
	BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor("a@gmail.com", "123456");
	}

	@Bean
	RestTemplate basicAuthRestTemplate() {
		RestTemplate restTemplate = new RestTemplate(new SimpleClientHttpRequestFactory());
		return restTemplate;
	}
}
