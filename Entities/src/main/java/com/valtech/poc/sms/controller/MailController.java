package com.valtech.poc.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.repo.MailRepo;
import com.valtech.poc.sms.service.ResetPasswordImpl;

@RestController
public class MailController {

	@Autowired
	MailRepo mailRepo;
	
	@Autowired
	ResetPasswordImpl resetPasswordImpl;
	

	@GetMapping("/getEmp/{empName}")
	public Employee getidbyemail(@PathVariable("empName") String empName) {
		return mailRepo.findByEmpName(empName);
	}
	
	@PostMapping("/reset/{email}")
	public String forgotPass(@PathVariable("email") String email) {
		boolean b = resetPasswordImpl.checkMailId(email);
		System.out.println(b);
		if (b == true) {
//		Boolean forgot =	forgotPass.generateOtp(user);
//		System.out.println(forgot);
//		String s1="sent";
//			return s1;
//		}
//		String s2="fail";
//		return s2;
	}
		return email;
	}
}
