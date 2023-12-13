package com.kata.series.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class RepositoryAspects {

	@Around(value = "execution(* com.kata.series.repository.*.*(..))")
	public Object logStartAndEndOfMethods(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("Starting Method : " + joinPoint.getSignature().toString());
		Object returnable = null;
		try {
			returnable = joinPoint.proceed(joinPoint.getArgs());
		} catch (Throwable e) {
			log.error("Error in class : " + this.getClass().getName() + "    :   error message : " + e.getMessage());
			log.error("Error while trying to log method : " + joinPoint.getSignature().toString());
			throw new Throwable(e);
		}
		log.info("We got this object : "+returnable.toString());
		log.info("Ending method : " + joinPoint.getSignature().toString());
		return returnable;
	}

	@AfterThrowing(pointcut = "execution(* com.kata.series.repository.*.*(..))", throwing = "ex")
	public void logExceptions(JoinPoint joinPoint, Exception ex) throws Throwable {
		log.error("Exception has occurred in : " + joinPoint.getSignature().toString());
		log.error("Error message : " + ex.getMessage());

	}
}
