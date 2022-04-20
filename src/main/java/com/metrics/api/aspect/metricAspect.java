package com.metrics.api.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class metricAspect {
	
	Counter totalHits, successHits;
	
	public metricAspect(MeterRegistry registry) {
		this.totalHits = registry.counter("newMBeanCounter");
	}
	
	@Pointcut("execution(* com.metrics.api.controller.*.*(..))")
	public void hitCounter() {
		
	}
	
	@Before("hitCounter()")
	public void before(JoinPoint jp) {
		totalHits.increment();
		System.out.print(Double.toString(totalHits.count()));
	}
	
	@AfterReturning("hitCounter()") 
	public void successfullHits(JoinPoint jp) {
		successHits.increment();
	}
}
