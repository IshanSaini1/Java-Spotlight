package com.kata.series.e1.aspects;

import java.time.Duration;
import java.time.Instant;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Around(value = "execution(* com.kata.series..*.*(..))")
	public void log(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info(joinPoint.getSignature().toString() + " has Started. ");
		Instant start = Instant.now();
		joinPoint.proceed();
		Instant finish = Instant.now();
		long timeTaken = Duration.between(start, finish).toMillis();
		log.info("Time taken to execute : " + timeTaken);
		log.info(joinPoint.getSignature().toString() + "  Finished");

	}
}
