package com.valtech.poc.sms.service;

import java.sql.SQLException;

import com.valtech.poc.sms.entities.Employee;

public interface ManagerService {

	Employee getManagerByEmpId(int empId) throws SQLException;

}