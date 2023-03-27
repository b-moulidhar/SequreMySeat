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
	public int getFoodCount(LocalDateTime dateTime) {
		String query="select count from Food where ft_date=?";
		return jdbcTemplate.queryForObject(query, Integer.class, dateTime);
	}

	@Override
	public int getSeatBookedCount(LocalDateTime dateTime) {
		String query="select count(sb_date) from seats_booked where sb_date=?"; 
	    return jdbcTemplate.queryForObject(query, Integer.class, dateTime);
	}
	
}
