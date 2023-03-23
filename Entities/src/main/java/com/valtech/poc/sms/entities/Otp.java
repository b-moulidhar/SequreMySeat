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
	private String otpKey;

	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}


	public Otp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getOtpKey() {
		return otpKey;
	}

	public void setOtpKey(String otpKey) {
		this.otpKey = otpKey;
	}

	public Otp(int oId, String otpKey) {
		super();
		this.oId = oId;
		this.otpKey = otpKey;
	}

	public Otp(String otpKey) {
		super();
		this.otpKey = otpKey;
	}

	@Override
	public String toString() {
		return "Otp [oId=" + oId + ", otpKey=" + otpKey + "]";
	}


	
	

}
