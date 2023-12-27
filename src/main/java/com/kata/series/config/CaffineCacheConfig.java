package com.kata.series.config;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.kata.series.kafka.modules.cache.keys.PaymentRequestCacheKeys;

@Configuration
public class CaffineCacheConfig {

	@Bean(name = "cachePurchaseRequest")
	public Cache<Integer, Boolean> cachePurchaseReqeust() {
		return Caffeine.newBuilder().expireAfterWrite(Duration.ofMinutes(2)).maximumSize(1000).build();
	}
	
	@Bean(name = "cachePaymentRequest")
	public Cache<PaymentRequestCacheKeys, Boolean> cachePaymentReqeust() {
		return Caffeine.newBuilder().expireAfterWrite(Duration.ofMinutes(2)).maximumSize(1000).build();
	}
	
	
	
}
