package com.metrics.api.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data 
@NoArgsConstructor  
@AllArgsConstructor 
@Getter
@Setter
@Entity
@Table(name="cpu_metrics")
public class Metric {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "host", nullable = false)
	private String hostName;
	
	@Column(name = "metric_type", nullable = false)
	private String metric_name;
	
	@Column(name = "metric_value", nullable = false)
	private Long metric_value;
	
	@Column(name = "time_stamp", nullable = false)
	private Timestamp timeStamp;
	
	public Metric(String hostName, String m_n, Long m_v) {
		super();
		this.hostName = hostName;
		this.metric_name = m_n;
		this.metric_value = m_v;
		this.timeStamp = new Timestamp(System.currentTimeMillis());
	}
}


