package com.valtech.poc.sms.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.poc.sms.repo.AdminRepository;
import com.valtech.poc.sms.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@GetMapping("/foodCount/{ftDate}")
	public void getFoodCount(@PathVariable("ftDate") String ftDate) {
		logger.info("Fetching the food count");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
		LocalDateTime dateTime = LocalDateTime.parse(ftDate, formatter);
		System.out.println(ftDate);
		String query="select count from Food where ft_date=?";  
	    int count= jdbcTemplate.queryForObject(query, Integer.class, dateTime);
	    System.out.println(count);
		//adminService.foodCount(ftDate);
	}
//	
//	@GetMapping("/foodCount/{ftDate}")
//	@ResponseBody
//	public int getCountByFtdate(@PathVariable("ftDate") String ftDate) {
//		    //  LocalDateTime localDate = LocalDateTime.parse(ftDate);
//		      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		      LocalDateTime localDate = LocalDateTime.parse(ftDate.substring(0, 10), formatter);
//		      return adminRepository.findCountByFtDate(localDate);
//		   }
//	}
//	

	 
}