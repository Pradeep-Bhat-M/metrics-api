package com.metrics.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
	
	@Override
	public String multipleInsertion() {
		
		String[] hosts = {"xyz.bmc.com", "abc.bmc.com"};
		String[] metric_name = {"cpu", "memory"};
		Random random = new Random();  
		int rows = random.nextInt(10) + 1;
		
		List<Metric> objectList = new ArrayList<Metric>();
		
		for(int i = 0; i < rows; i++) {
			int m_index = random.nextInt(2);   
			int h_index = random.nextInt(2);
			
			Long value;
			
			if(m_index == 0)
				value = Math.abs(random.nextLong() % 100);
			else
				value = Math.abs(random.nextLong() % 100000000);
			
//			objectList[i] = new Metric(hosts[h_index],metric_name[m_index], value);
			Metric object = new Metric(hosts[h_index],metric_name[m_index], value);
			objectList.add(object);
		}
		
		mR.saveAll(objectList);
		
		return "All rows inserted Succesfully \n";
	}

	@Override
	public Metric returnMetric(long id) {
		// TODO Auto-generated method stub
		return mR.findById(id).orElseThrow();
	}

}
