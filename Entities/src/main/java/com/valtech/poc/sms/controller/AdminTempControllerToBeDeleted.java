package com.valtech.poc.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.poc.sms.service.ResetPassword;

@RestController
public class AdminTempControllerToBeDeleted {


	@GetMapping("/qr/codeGenerator/{empId}")
	public String getCodeForQrGeneration(@PathVariable("empId") int empId) {
		return null;
		//call function which returns code from seat_booked table based on current status
	}
	
	@Autowired
	ResetPassword resetPassword;
	
	public String generateQrCode(int empId) {
		String code = empId + resetPassword.getRandomNumberString();
		return code;
	}

}
