package com.metrics.api.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
//import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@ManagedResource(objectName="newMBeans:category=MBeans,name=testBean")
public class metricAspect {
	
	final Counter totalHits, successHits;
	
	public metricAspect(MeterRegistry registry) {
		this.totalHits = registry.counter("totalHits");
		this.successHits = registry.counter("successHits");
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
		System.out.print("\nHit Count = " + Double.toString(successHits.count()));
	}

	@ManagedOperation
    public String getTotalHits() throws InterruptedException {
        return "Total Hits = " + totalHits.count();
    }
	
	@ManagedOperation
    public String getSuccessHits() throws InterruptedException {
        return "Succesfull Hits = " + successHits.count();
    }
}
