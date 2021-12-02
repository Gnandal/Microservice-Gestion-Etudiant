package com.gev.program.models;

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

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "program")
@Data
@AllArgsConstructor
public class Program {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_program;
	
	@Length(min = 4, max = 20)
	private String level;
	
	@Column(columnDefinition = "TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date d_publish;

	private String url;
	
	public Program() {}
}
