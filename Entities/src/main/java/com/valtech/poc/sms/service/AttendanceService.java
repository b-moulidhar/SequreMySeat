package com.valtech.poc.sms.service;

import java.util.List;
import java.util.Map;

import com.valtech.poc.sms.entities.AttendanceTable;
import com.valtech.poc.sms.entities.Employee;

public interface AttendanceService {

	Employee getSpecificEmployee(AttendanceTable attendance);

	AttendanceTable getList(int atId);

	List<Map<String, Object>> getCompleteAttendanceList();

	Map<String, Object> getAttendanceListForEachEmployee(int atId);

	List<Map<String, Object>> getAttendanceForEmployeeBasedOnEmployeeId(int eId);

	List<Map<String, Object>> getAttendanceListForApproval(int eId);

	void deleteAttendanceRequest(int atId);

	String getMailIdByAtId(int atId);

	void automaticRegularization(int sbId, AttendanceTable attendance);

	void updateAttendance(int atId);

	void saveAttendance(Employee emp, AttendanceTable attendance);
}
