package com.valtech.poc.sms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Otp")
public class Otp {
	@Id
	@Column(name = "oId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int oId;
	private String key;

	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Otp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Otp(String key) {
		super();
		this.key = key;
	}

	public Otp(int oId, String key) {
		super();
		this.oId = oId;
		this.key = key;
	}

	@Override
	public String toString() {
		return "Otp [oId=" + oId + ", key=" + key + "]";
	}

}
