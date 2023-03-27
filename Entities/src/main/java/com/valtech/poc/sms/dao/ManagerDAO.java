package com.valtech.poc.sms.dao;


import com.valtech.poc.sms.entities.Employee;

public interface ManagerDAO {

	Employee getManagerByEmpId(int empId);



}