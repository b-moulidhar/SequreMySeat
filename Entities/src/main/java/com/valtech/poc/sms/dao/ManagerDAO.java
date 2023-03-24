package com.valtech.poc.sms.dao;

import com.valtech.poc.sms.entities.User;

public interface ManagerDAO {

	User getManagerByEmpId(int empId);

}