package com.valtech.poc.sms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AttendanceTable")
public class AttendanceTable {
	@Id
	@Column(name = "atId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int atId;
	private String startDate;
	private String endDate;
	private String shiftStart;
	private Manager shiftEnd;
	private Employee eId;

	public int getAtId() {
		return atId;
	}

	public void setAtId(int atId) {
		this.atId = atId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getShiftStart() {
		return shiftStart;
	}

	public void setShiftStart(String shiftStart) {
		this.shiftStart = shiftStart;
	}

	public Manager getShiftEnd() {
		return shiftEnd;
	}

	public void setShiftEnd(Manager shiftEnd) {
		this.shiftEnd = shiftEnd;
	}

	public Employee geteId() {
		return eId;
	}

	public void seteId(Employee eId) {
		this.eId = eId;
	}

	public AttendanceTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AttendanceTable(String startDate, String endDate, String shiftStart, Manager shiftEnd, Employee eId) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.shiftStart = shiftStart;
		this.shiftEnd = shiftEnd;
		this.eId = eId;
	}

	public AttendanceTable(int atId, String startDate, String endDate, String shiftStart, Manager shiftEnd,
			Employee eId) {
		super();
		this.atId = atId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.shiftStart = shiftStart;
		this.shiftEnd = shiftEnd;
		this.eId = eId;
	}

	@Override
	public String toString() {
		return "AttendanceTable [atId=" + atId + ", startDate=" + startDate + ", endDate=" + endDate + ", shiftStart="
				+ shiftStart + ", shiftEnd=" + shiftEnd + ", eId=" + eId + "]";
	}

}