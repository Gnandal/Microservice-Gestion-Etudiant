package com.gev.program.models;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "program")
public class Program {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_program;
	
	@Length(min = 4, max = 20)
	private String level;
	
	@Column(columnDefinition = "TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date d_publish;
	
	@Lob
	private byte[] image;

	public long getId_program() {
		return id_program;
	}

	public void setId_program(long id_program) {
		this.id_program = id_program;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Date getD_publish() {
		return d_publish;
	}

	public void setD_publish(Date d_publish) {
		this.d_publish = d_publish;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Program [id_program=" + id_program + ", "
				+ "level=" + level + ", "
				+ "d_publish=" + d_publish + ", "
				+ "image="+ Arrays.toString(image) 
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((d_publish == null) ? 0 : d_publish.hashCode());
		result = prime * result + (int) (id_program ^ (id_program >>> 32));
		result = prime * result + Arrays.hashCode(image);
		result = prime * result + ((level == null) ? 0 : level.hashCode());
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
		Program other = (Program) obj;
		if (d_publish == null) {
			if (other.d_publish != null)
				return false;
		} else if (!d_publish.equals(other.d_publish))
			return false;
		if (id_program != other.id_program)
			return false;
		if (!Arrays.equals(image, other.image))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		return true;
	}

}
