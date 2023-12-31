package com.valtech.poc.sms.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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
		String query="select count(sb_start_date) from seats_booked where sb_start_date=?"; 
	    return jdbcTemplate.queryForObject(query, Integer.class, dateTime);
	}

	@Override
	public List<String> findRoles() {
		String query="select role from roles";
		return jdbcTemplate.queryForList(query, String.class);

	}


	@Override
	public void approroveRegistration(int uId) {
		// TODO Auto-generated method stub
		String sql="UPDATE user SET approval=? WHERE u_id=?";
		jdbcTemplate.update(sql, 1 ,uId);
	}
	public List<Map<String, Object>> getRegistrationListForApproval() {
		String query = "SELECT emp_id,emp_name,mail_id,ph_num,m_id,approval FROM user u JOIN employee e ON u.e_id = e.e_id  WHERE approval=?";
        List<Map<String, Object>> results = jdbcTemplate.queryForList(query,false);
        return results;
	}

	@Override
	public void deleteUser(int uId) {
		// TODO Auto-generated method stub
		String sql="delete from user where u_id=?";
		jdbcTemplate.update(sql,uId);
	}
	public List<String> findShiftStartTimings() {
		String query="select st_start from shift_timings";
		return jdbcTemplate.queryForList(query, String.class);
	}

	@Override
	public List<String> findShiftEndTimings() {
		String query="select st_end from shift_timings";
		return jdbcTemplate.queryForList(query, String.class);
	}
	
}