package com.valtech.poc.sms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	@Id
	@Column(name = "uId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int uId;
	private int empId;
	private String pass;
	private Employee empDetails;
	private Roles role;
	private Otp otp;
	private boolean approval;

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Employee getEmpDetails() {
		return empDetails;
	}

	public void setEmpDetails(Employee empDetails) {
		this.empDetails = empDetails;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public Otp getOtp() {
		return otp;
	}

	public void setOtp(Otp otp) {
		this.otp = otp;
	}

	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int uId, int empId, String pass, Employee empDetails, Roles role, Otp otp, boolean approval) {
		super();
		this.uId = uId;
		this.empId = empId;
		this.pass = pass;
		this.empDetails = empDetails;
		this.role = role;
		this.otp = otp;
		this.approval = approval;
	}

	public User(int empId, String pass, Employee empDetails, Roles role, Otp otp, boolean approval) {
		super();
		this.empId = empId;
		this.pass = pass;
		this.empDetails = empDetails;
		this.role = role;
		this.otp = otp;
		this.approval = approval;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", empId=" + empId + ", pass=" + pass + ", empDetails=" + empDetails + ", role="
				+ role + ", otp=" + otp + ", approval=" + approval + "]";
	}

}
