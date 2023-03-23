package com.valtech.poc.sms.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SeatsBooked")
public class SeatsBooked {
	@Id
	@Column(name = "sbId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int sbId;
	private LocalDateTime sbDate;
	private LocalDateTime punchIn;
	private LocalDateTime punchOut;
	private boolean current;
	private String code;
	private Seat sId;
	private Employee eId;

	public int getSbId() {
		return sbId;
	}

	public void setSbId(int sbId) {
		this.sbId = sbId;
	}

	public LocalDateTime getSbDate() {
		return sbDate;
	}

	public void setSbDate(LocalDateTime sbDate) {
		this.sbDate = sbDate;
	}

	public LocalDateTime getPunchIn() {
		return punchIn;
	}

	public void setPunchIn(LocalDateTime punchIn) {
		this.punchIn = punchIn;
	}

	public LocalDateTime getPunchOut() {
		return punchOut;
	}

	public void setPunchOut(LocalDateTime punchOut) {
		this.punchOut = punchOut;
	}

	public boolean isCurrent() {
		return current;
	}

	public void setCurrent(boolean current) {
		this.current = current;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Seat getsId() {
		return sId;
	}

	public void setsId(Seat sId) {
		this.sId = sId;
	}

	public Employee geteId() {
		return eId;
	}

	public void seteId(Employee eId) {
		this.eId = eId;
	}

	public SeatsBooked() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SeatsBooked(int sbId, LocalDateTime sbDate, LocalDateTime punchIn, LocalDateTime punchOut, boolean current,
			String code, Seat sId, Employee eId) {
		super();
		this.sbId = sbId;
		this.sbDate = sbDate;
		this.punchIn = punchIn;
		this.punchOut = punchOut;
		this.current = current;
		this.code = code;
		this.sId = sId;
		this.eId = eId;
	}

	public SeatsBooked(LocalDateTime sbDate, LocalDateTime punchIn, LocalDateTime punchOut, boolean current,
			String code, Seat sId, Employee eId) {
		super();
		this.sbDate = sbDate;
		this.punchIn = punchIn;
		this.punchOut = punchOut;
		this.current = current;
		this.code = code;
		this.sId = sId;
		this.eId = eId;
	}

	@Override
	public String toString() {
		return "SeatsBooked [sbId=" + sbId + ", sbDate=" + sbDate + ", punchIn=" + punchIn + ", punchOut=" + punchOut
				+ ", current=" + current + ", code=" + code + ", sId=" + sId + ", eId=" + eId + "]";
	}

}