package com.gev.result.models;

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

@Entity
@Table(name = "result")
public class Result {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_result;
	
	private String module;
	
	private String level;
	
	@Column(columnDefinition = "TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date d_publish;
	
	@Lob
	private byte[] image;

	public long getId_result() {
		return id_result;
	}

	public void setId_result(long id_result) {
		this.id_result = id_result;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
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
		return "Result [id_result=" + id_result + ","
				+ " module=" + module + ", "
				+ "level=" + level + ", "
				+ "d_publish=" + d_publish + ", "
				+ "image=" + Arrays.toString(image) 
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((d_publish == null) ? 0 : d_publish.hashCode());
		result = prime * result + (int) (id_result ^ (id_result >>> 32));
		result = prime * result + Arrays.hashCode(image);
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((module == null) ? 0 : module.hashCode());
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
		Result other = (Result) obj;
		if (d_publish == null) {
			if (other.d_publish != null)
				return false;
		} else if (!d_publish.equals(other.d_publish))
			return false;
		if (id_result != other.id_result)
			return false;
		if (!Arrays.equals(image, other.image))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		return true;
	}
}
