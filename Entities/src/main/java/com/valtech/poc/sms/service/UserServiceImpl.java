package com.valtech.poc.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.entities.User;
import com.valtech.poc.sms.repo.EmployeeRepo;
import com.valtech.poc.sms.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userepo;

	@Autowired
//	EmployeeRepo employeeRepo;
	EmployeeRepo empRepo;

	@Override
	public User findByEmail(String email) {
		Employee emp = empRepo.findByMailId(email);
		User usr = userepo.findByEmpDetails(emp);
		System.out.println("usr= " + usr);
		return usr;
	}

}
