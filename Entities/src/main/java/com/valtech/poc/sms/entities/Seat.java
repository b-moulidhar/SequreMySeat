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


	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seat(int sId, String sName) {
		super();
		this.sId = sId;
		this.sName = sName;
	}

	public Seat(String sName) {
		super();
		this.sName = sName;
	}

	@Override
	public String toString() {
		return "Seat [sId=" + sId + ", sName=" + sName +"]";
	}

}
