package com.valtech.poc.sms.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Food")
public class Food {
	@Id
	@Column(name = "ftId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int ftId;
	private LocalDateTime ftDate;
	private int count;

	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Food(int ftId, LocalDateTime ftDate, int count) {
		super();
		this.ftId = ftId;
		this.ftDate = ftDate;
		this.count = count;
	}

	@Override
	public String toString() {
		return "Food [ftId=" + ftId + ", ftDate=" + ftDate + ", count=" + count + "]";
	}

	public int getFtId() {
		return ftId;
	}

	public void setFtId(int ftId) {
		this.ftId = ftId;
	}

	public LocalDateTime getFtDate() {
		return ftDate;
	}

	public void setFtDate(LocalDateTime ftDate) {
		this.ftDate = ftDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Food(LocalDateTime ftDate, int count) {
		super();
		this.ftDate = ftDate;
		this.count = count;
	}

}