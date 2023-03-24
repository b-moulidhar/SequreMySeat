package com.valtech.poc.sms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class Roles {
	@Id
	@Column(name = "rId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int rId;
	@Column(unique = true)
	private String role;

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Roles(int rId, String role) {
		super();
		this.rId = rId;
		this.role = role;
	}

	public Roles(String role) {
		super();
		this.role = role;
	}

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Roles [rId=" + rId + ", role=" + role + "]";
	}

}