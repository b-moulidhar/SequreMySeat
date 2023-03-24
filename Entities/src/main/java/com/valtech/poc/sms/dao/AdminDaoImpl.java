package com.valtech.poc.sms.dao;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AdminDaoImpl implements AdminDao {
    
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void foodCount(LocalDateTime foodDate){  
	    String query="select count from Food where ftDate=foodDate";  
	    jdbcTemplate.update(query);  
	}  
	
	
}
