package com.kata.series.e1.aspects.aspect_classes;

import java.time.Duration;
import java.time.Instant;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Order(1)
	@Around(value = "execution(* com.kata.series.e1.aspects..*.*(..))")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info(joinPoint.getSignature().toString() + " has Started. ");
		Instant start = Instant.now();
		Object object = joinPoint.proceed(joinPoint.getArgs());
		Instant finish = Instant.now();
		long timeTaken = Duration.between(start, finish).toMillis();
		log.info("Time taken to execute : " + timeTaken);
		log.info(joinPoint.getSignature().toString() + "  Finished");
		return object;

	}

	@Order(2)
	@Before(value = "execution(* com.kata.series.e1.aspects..*.*(..))")
	public void logStart(JoinPoint jp) throws Throwable {
		log.info(jp.getSignature().toString() + " has Started. ");

	}

}
