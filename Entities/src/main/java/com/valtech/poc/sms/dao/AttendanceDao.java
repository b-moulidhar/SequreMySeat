package com.valtech.poc.sms.dao;

import java.util.List;
import java.util.Map;

import com.valtech.poc.sms.entities.AttendanceTable;

public interface AttendanceDao {

	AttendanceTable getList(int atId);

	List<Map<String, Object>> getCompleteAttendanceList();

	Map<String, Object> getAttendanceListForEachEmployee(int atId);

	List<Map<String, Object>> getAttendanceForEmployeeBasedOnEmployeeId(int eId);

	List<Map<String, Object>> getAttendanceListForApproval(int eId);
	
	void approveAttendance(int atId);
	
	void deleteAttendanceRequest(int atId);
	
	String getMailIdByAtId(int atId);
}
