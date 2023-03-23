package com.valtech.poc.sms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Manager")
public class Manager {
	@Id
	@Column(name = "mId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int mId;
	private Employee managerDetails;

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public Employee getManagerDetails() {
		return managerDetails;
	}

	public void setManagerDetails(Employee managerDetails) {
		this.managerDetails = managerDetails;
	}

	@Override
	public String toString() {
		return "Manager [mId=" + mId + ", managerDetails=" + managerDetails + "]";
	}

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(int mId, Employee managerDetails) {
		super();
		this.mId = mId;
		this.managerDetails = managerDetails;
	}

	public Manager(Employee managerDetails) {
		super();
		this.managerDetails = managerDetails;
	}

}
