package com.valtech.poc.sms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Seat")
public class Seat {
	@Id
	@Column(name = "sId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int sId;
	private String sName;
	private Floors fId;

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public Floors getfId() {
		return fId;
	}

	public void setfId(Floors fId) {
		this.fId = fId;
	}

	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seat(int sId, String sName, Floors fId) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.fId = fId;
	}

	public Seat(String sName, Floors fId) {
		super();
		this.sName = sName;
		this.fId = fId;
	}

	@Override
	public String toString() {
		return "Seat [sId=" + sId + ", sName=" + sName + ", fId=" + fId + "]";
	}

}
