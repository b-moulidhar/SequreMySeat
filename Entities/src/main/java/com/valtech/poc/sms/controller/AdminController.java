package com.valtech.poc.sms.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.valtech.poc.sms.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;
	
	private final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@GetMapping("/foodCount/{ftDate}")
	public void getFoodCount(@PathVariable("ftDate") LocalDateTime ftDate) {
		logger.info("Fetching the food count");
		System.out.println(ftDate);
		adminService.foodCount(ftDate);
	}
}
