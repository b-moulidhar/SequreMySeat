package com.valtech.poc.sms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.entities.User;

@Component
public class UserDAOImpl implements UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int getMidByMname(String managerName) {
		String sql="select m_id from manager where e_id=(select e_id from employee where emp_name=?)";
		return jdbcTemplate.queryForObject(sql, Integer.class,managerName);
	}

	@Override
	public void saveEmployee(Employee employee, int mId) {
		String sql="insert into employee values (?,?,?,?,?)";
		jdbcTemplate.update(sql,7,employee.getEmpName(),employee.getMailId(),employee.getPhNum(),mId);
	}

	@Override
	public void saveUser(User user, Employee eId) {
		String sql="insert into user values (?,?,?,?,?,?)";
		jdbcTemplate.update(sql,7,false,user.getEmpId(),user.getPass(),eId.geteId(),null);
	}

	@Override
	public int getRidByRoleName(String role) {
		String sql="select r_id from roles where role=?";
		return jdbcTemplate.queryForObject(sql, Integer.class,role);
	}

	@Override
	public void saveUserRole(int uId, int rId) {
		String sql="insert into user_roles values(?,?)";
		jdbcTemplate.update(sql,uId,rId);
	}

	@Override
	public void saveManager(int mId, int eId) {
		String sql="insert into manager values (?,?)";
		jdbcTemplate.update(sql,mId,eId);
	}

}