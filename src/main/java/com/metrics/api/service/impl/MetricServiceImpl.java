package com.metrics.api.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.metrics.api.model.Metric;
import com.metrics.api.repository.MetricRepository;
import com.metrics.api.service.metricService;



@Service
public class MetricServiceImpl implements metricService{
	
	private MetricRepository mR;
	
	public MetricServiceImpl(MetricRepository mR) {
		super();
		this.mR = mR;
	}
	
	@Override
	public String insertMetric() {

		
		String[] hosts = {"xyz.bmc.com", "abc.bmc.com"};
		String[] metric_name = {"cpu", "memory"};
		
		
		Random random = new Random();   
		// Generates random integers 0 to 1
		int m_index = random.nextInt(2);   
		int h_index = random.nextInt(2);
		
		Long value;
		
		if(m_index == 0)
			value = Math.abs(random.nextLong() % 100);
		else
			value = Math.abs(random.nextLong() % 100000000);
		
		Metric object = new Metric(hosts[h_index],metric_name[m_index], value);
		
		mR.save(object);
		
		return "Data inserted Succesfully \n";
	}

}
