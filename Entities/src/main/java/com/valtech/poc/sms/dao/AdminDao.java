package com.valtech.poc.sms.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.valtech.poc.sms.entities.AttendanceTable;

public interface AdminDao {

	int getFoodCount(LocalDateTime dateTime);

	int getSeatBookedCount(LocalDateTime dateTime);
	
	void approveAttendance(int atId);

	List<AttendanceTable> listAttendance();

	List<String> findRoles();

}