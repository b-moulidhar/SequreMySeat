package com.valtech.poc.sms.service;

import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.entities.User;

public interface UserService{

	String login(int empId, String pass);
	User findByEmpId(int empId);
	void register(int empId, String pass, Employee empDetails);
	User findByEmail(String email);
    

}