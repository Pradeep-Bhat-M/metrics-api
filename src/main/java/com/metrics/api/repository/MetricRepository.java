package com.metrics.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metrics.api.model.Metric;

public interface MetricRepository extends JpaRepository<Metric, Long> {

}
