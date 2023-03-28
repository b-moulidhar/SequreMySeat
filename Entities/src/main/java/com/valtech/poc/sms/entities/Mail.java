package com.valtech.poc.sms.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Mail")
public class Mail {
	@Id
	@Column(name = "mId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int mId;
	private String email;
	private String subject;
	private String body;
	private boolean status;

	public Mail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mail(int mId, String email, String subject, String body, boolean status) {
		super();
		this.mId = mId;
		this.email = email;
		this.subject = subject;
		this.body = body;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Mail [mId=" + mId + ", email=" + email + ", subject=" + subject + ", body=" + body + ", status="
				+ status + "]";
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Mail(String email, String subject, String body, boolean status) {
		super();
		this.email = email;
		this.subject = subject;
		this.body = body;
		this.status = status;
	}

}
