package com.valtech.poc.sms.service;

import java.util.List;

import com.valtech.poc.sms.entities.AttendanceTable;
import com.valtech.poc.sms.entities.Employee;

public interface AdminService {

	int getFoodCount(String ftDate);

	int getSeatBookedCount(String sbDate);

	int getCount(String ftDate);
	
	void updateAttendance(int atId);

	List<AttendanceTable> listAttendance();

	List<String> findRoles();

	void automaticRegularization(int sbId, AttendanceTable attendance);

	Employee getSpecificEmploye(AttendanceTable attendance);



}