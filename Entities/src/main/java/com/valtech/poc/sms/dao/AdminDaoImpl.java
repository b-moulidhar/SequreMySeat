package com.valtech.poc.sms.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AdminDaoImpl implements AdminDao {
    
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void foodCount(String foodDate){  
		LocalDateTime localDateTime = LocalDateTime.parse(foodDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	    String query="select count from Food where ft_date=?";  
	    jdbcTemplate.queryForObject(query, Integer.class, localDateTime);  
	}  
	
	
}
