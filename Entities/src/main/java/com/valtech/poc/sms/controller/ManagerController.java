package com.valtech.poc.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.service.ManagerService;

@Controller
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	
	@GetMapping("/managerByEmpId/{empId}")
	public Employee managerProfileInfo(@PathVariable int empId) {
		System.out.println(managerService.getManagerByEmpId(empId).getuId());
		return managerService.getManagerByEmpId(empId).getEmpDetails();
	}
}
