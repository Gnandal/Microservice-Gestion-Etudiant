package com.gev.admin.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "admin")
@DynamicUpdate
@Data
@AllArgsConstructor
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_admin;
	
	@Length(min = 4, max=30)
	private String firstname;
	
	@Length(min = 4, max=50)
	private String secondname;
	
	@Length(min = 3, max=20)
	private String login;
	
	@Length(min = 6, max=20)
	private String password;

	public Admin() {}

}
