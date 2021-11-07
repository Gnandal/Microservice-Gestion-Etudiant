package com.gev.student.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@Length(max=9)
	private String Matricule;
	
	@Length(min = 4, max = 30)
	private String firstname;
	
	@Length(min = 4, max = 50)
	private String secondname;
	
	@Length(min = 3, max = 20)
	private String login;
	
	@Length(min = 4, max = 20)
	private String level;
	
	@Length(min = 5, max = 60)
	private String email;
	
	@Length(min = 6, max = 20)
	private String password;
	
	@Column(length = 8)
	private long   telephone;

	public String getMatricule() {
		return Matricule;
	}

	public void setMatricule(String matricule) {
		Matricule = matricule;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Student [Matricule=" + Matricule + ", "
			    + "firstname=" + firstname + ", "
			    + "secondname=" + secondname + ", "
			    + "login=" + login + ", "
			    + "level=" + level + ", "
			    + "email=" + email + ", "
			    + "password=" + password + ", "
			    + "telephone=" + telephone 
			    + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Matricule == null) ? 0 : Matricule.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((secondname == null) ? 0 : secondname.hashCode());
		result = prime * result + (int) (telephone ^ (telephone >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (Matricule == null) {
			if (other.Matricule != null)
				return false;
		} else if (!Matricule.equals(other.Matricule))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (secondname == null) {
			if (other.secondname != null)
				return false;
		} else if (!secondname.equals(other.secondname))
			return false;
		if (telephone != other.telephone)
			return false;
		return true;
	}
}
