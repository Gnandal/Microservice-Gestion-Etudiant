package com.gev.result.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "result")
@Data
public class Result {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_result;
	
	private String module;
	
	private String level;
	
	@Column(columnDefinition = "TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date d_publish;
	
	private String url;
	
	public Result(String module, String level, Date d_publish, String url) {
		super();
		this.module = module;
		this.level = level;
		this.d_publish = d_publish;
		this.url = url;
	}
}
