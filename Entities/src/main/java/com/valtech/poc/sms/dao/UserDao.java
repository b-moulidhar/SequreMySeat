package com.valtech.poc.sms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.entities.User;

@Repository
public class UserDao implements RowMapper<User> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setuId(rs.getInt("uId"));
        user.setEmpId(rs.getInt("empId"));
        user.setPass(rs.getString("pass"));
        user.setEmpDetails(rs.getObject("empDetails", Employee.class));
        user.setApproval(rs.getBoolean("approval"));
        return user;
    }

    public User findByEmpId(int empId) {
        String sql = "SELECT * FROM User WHERE emp_id = ?";
        User user = jdbcTemplate.queryForObject(sql, new Object[]{empId}, this);
        return user;
    }

    public void save(User user) {
        String sql = "INSERT INTO User (empId, pass, empDetails, approval) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getEmpId(), user.getPass(), user.getEmpDetails(), user.isApproval());
    }
}
