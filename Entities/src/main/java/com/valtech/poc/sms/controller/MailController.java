package com.valtech.poc.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.service.EmployeeService;
import com.valtech.poc.sms.service.ResetPassword;

@RestController
public class MailController {

	@Autowired
	EmployeeService empService;

	@Autowired
	ResetPassword resetPassword;

	@ResponseBody
	@PostMapping("/reset/{email}")
	public String forgotPass(@PathVariable("email") String email) {
		boolean b = resetPassword.checkMailId(email);
		System.out.println(b);
		if (b == true) {
			Boolean forgot = resetPassword.generateOtp(email);
			System.out.println(forgot);
			String s1 = "sent";
			return s1;
		}
		String s2 = "fail";
		return s2;
	}

	@PostMapping("/reset/newPass/{id}")
	public String newPass(@PathVariable("id") int id, @RequestParam String otpKey, @RequestParam String newPassword) {

		Employee emp = empService.findById(id);
		String email = emp.getMailId();
		System.out.println("test mail= " + email);
		boolean b = resetPassword.newPasswod(email, otpKey, newPassword);
		System.out.println(b);
		if (b == true) {
//			String password = bCryptPasswordEncoder.encode(user.getPassword());
			return "changed";
		}
		return "fail";
	}

}
