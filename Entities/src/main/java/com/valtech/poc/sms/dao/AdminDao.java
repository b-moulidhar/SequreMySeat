package com.valtech.poc.sms.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.valtech.poc.sms.entities.AttendanceTable;

public interface AdminDao {

	int getFoodCount(LocalDateTime dateTime);

	int getSeatBookedCount(LocalDateTime dateTime);
	
	void approveAttendance(int atId);

	List<String> findRoles();

	AttendanceTable getList(int atId);

	List<Map<String, Object>> getCompleteAttendanceList();

	Map<String, Object> getAttendanceListForEachEmployee(int atId);

}