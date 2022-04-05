package com.metrics.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metrics.api.service.metricService;


@RestController
@RequestMapping("/metrics")
public class Controller {
	private metricService mS;

	public Controller(metricService mS) {
		super();
		this.mS = mS;
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<String>("Test Succesfull!! \n", HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addMetric() {
		return new ResponseEntity<String>(mS.insertMetric(), HttpStatus.CREATED);
	}
	
	@PostMapping("/add-list")
	public ResponseEntity<String> multipleInsertion() {
		return new ResponseEntity<String>(mS.multipleInsertion(), HttpStatus.CREATED);
	}
}


	