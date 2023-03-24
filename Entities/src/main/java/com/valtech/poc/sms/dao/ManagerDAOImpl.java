package com.valtech.poc.sms.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.valtech.poc.sms.entities.Employee;

@Component
public class ManagerDAOImpl implements ManagerDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	@Override
	public Employee getManagerByEmpId(int empId) {
		// TODO Auto-generated method stub
		String sql="select * from employee where e_id=(select e_id from user u where u.emp_id=? AND u.u_id=(select ur.u_id from roles r INNER JOIN user_roles ur ON r.r_id = ur.r_id AND r.role in ('Manager')));";
		
		 return (Employee) jdbcTemplate.queryForObject(
					sql, 
					new Object[]{empId}, 
					new BeanPropertyRowMapper(Employee.class));
	}

}
