package com.valtech.poc.sms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.poc.sms.dao.EmployeeDAO;
import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	EmployeeRepo empRepo;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public Employee findByEmpName(String empName) {
		return empRepo.findByEmpName(empName);
	}
	
	@Override
	public Employee findById(int id) {
		return empRepo.findById(id).get();
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		logger.info("Getting All Employee Details");
		return employeeDAO.getAllEmployees();
	}
}
