package com.aakash.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long dId;
	private String name;
	private String specification;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date availableDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	private Date availableDateStart;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	private Date availableDateEnd;

	public Doctor() {
		super();
	}

	public Doctor(long dId) {
		super();
		this.dId = dId;
	}

	public long getdId() {
		return dId;
	}

	public void setdId(long dId) {
		this.dId = dId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public Date getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}

	public Date getAvailableDateStart() {
		return availableDateStart;
	}

	public void setAvailableDateStart(Date availableDateStart) {
		this.availableDateStart = availableDateStart;
	}

	public Date getAvailableDateEnd() {
		return availableDateEnd;
	}

	public void setAvailableDateEnd(Date availableDateEnd) {
		this.availableDateEnd = availableDateEnd;
	}

	@Override
	public String toString() {
		return "Doctor [dId=" + dId + ", name=" + name + ", specification=" + specification + ", availableDate="
				+ availableDate + ", availableDateStart=" + availableDateStart + ", availableDateEnd="
				+ availableDateEnd + "]";
	}

}
