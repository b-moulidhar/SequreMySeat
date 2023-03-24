package com.valtech.poc.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepo empRepo;

	@Override
	public Employee findByEmpName(String empName) {
		return empRepo.findByEmpName(empName);
	}
	
	@Override
	public Employee findById(int id) {
		return empRepo.findById(id).get();
	}
}
