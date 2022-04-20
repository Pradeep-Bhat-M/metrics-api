package com.metrics.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
//import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
//
//import org.springframework.stereotype.Component;
//
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;

@SpringBootApplication
public class MetricsApiApplication {
	
//	@Component
//	@Endpoint(id = "helloworld")
//	public class HelloWorldEndpoint {
//	    @ReadOperation
//	    public Message read() {
//	        return new Message("Hello world");
//	    }
//
//	    @Getter
//	    @RequiredArgsConstructor
//	    public class Message {
//	        private final String message;
//	    }
//	}

	public static void main(String[] args) {
		SpringApplication.run(MetricsApiApplication.class, args);
	}

}
