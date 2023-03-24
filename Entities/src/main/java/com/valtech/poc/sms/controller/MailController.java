package com.valtech.poc.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.entities.User;
//import com.valtech.poc.sms.repo.EmployeeRepo;
import com.valtech.poc.sms.repo.MailRepo;
import com.valtech.poc.sms.repo.UserepoTemp;
import com.valtech.poc.sms.service.ResetPasswordImpl;

@RestController
public class MailController {

//	@Autowired
//	EmployeeRepo employeeRepo;

	@Autowired
	MailRepo mailRepo;

	@Autowired
	ResetPasswordImpl resetPasswordImpl;
	
	@Autowired
	UserepoTemp temp;

	@GetMapping("/getEmp/{empName}")
	public Employee getidbyemail(@PathVariable("empName") String empName) {
		return mailRepo.findByEmpName(empName);
	}

	@PostMapping("/reset/{email}")
	public String forgotPass(@PathVariable("email") String email) {
		boolean b = resetPasswordImpl.checkMailId(email);
		System.out.println(b);
		if (b == true) {
			Boolean forgot = resetPasswordImpl.generateOtp(email);
			System.out.println(forgot);
			String s1 = "sent";
			return s1;
		}
		String s2 = "fail";
		return s2;
	}

	@PostMapping("/reset/newPass/{id}")
	public String newPass(@PathVariable("id") int id, @RequestParam String otpKey, @RequestParam String newPassword) {

//		String otp = user.getEmail();
		Employee emp = mailRepo.findById(id).get();
		String email = emp.getMailId();
//		User usr=temp.findByEmpDetails(emp);
//		String email="temp";
		System.out.println("test mail= " + email);
		boolean b = resetPasswordImpl.newPasswod(email, otpKey, newPassword);
		System.out.println(b);
		if (b == true) {
//			String password = bCryptPasswordEncoder.encode(user.getPassword());
//			forgotPass.changepassword(id, password);
			return "changed";
		}
		return "fail";
	}

}
