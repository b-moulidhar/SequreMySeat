package com.valtech.poc.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.entities.User;
import com.valtech.poc.sms.repo.MailRepo;
//import com.valtech.poc.sms.repo.EmployeeRepo;
import com.valtech.poc.sms.repo.UserepoTemp;

@Service
public class UserServiceTempImpl {

	@Autowired
	UserepoTemp userepoTemp;

	@Autowired
//	EmployeeRepo employeeRepo;
	MailRepo mailRepo;

	public User findByEmail(String email) {
		Employee emp = mailRepo.findByMailId(email);
		User usr = userepoTemp.findByEmpDetails(emp);
		System.out.println("usr= " + usr);
		return usr;
	}

}
