package com.metrics.api.service;

import com.metrics.api.model.Metric;

public interface metricService {
	public String insertMetric();
	public String multipleInsertion();
	public Metric returnMetric(long id);
}