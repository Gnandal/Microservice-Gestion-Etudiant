package com.gev.information.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Entity
@Table(name="information")
@Data
public class Information {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="d_publish", columnDefinition = "TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date d_publish;
	
	private String body;
	
	private String title;
	
	@Length(min=4, max=20)
	private String level;

	private String url;
	
	public Information() {
		
	}
	
	public Information(Date d_publish, @Length(min = 4, max = 20) String level, String url) {
		super();
		this.d_publish = d_publish;
		this.level = level;
		this.url = url;
	}
}
