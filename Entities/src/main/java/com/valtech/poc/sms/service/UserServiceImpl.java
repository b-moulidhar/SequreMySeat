package com.valtech.poc.sms.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.valtech.poc.sms.dao.UserDao;
import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.entities.User;
import com.valtech.poc.sms.repo.EmployeeRepo;
import com.valtech.poc.sms.repo.UserRepo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserServiceImpl implements UserService,UserDetailsService {

	@Autowired
	private UserRepo userepo;

	@Autowired
	private EmployeeRepo employeeRepo;


	@Override
	public User findByEmail(String email) {
		Employee emp = employeeRepo.findByMailId(email);
		User usr = userepo.findByEmpDetails(emp);
		System.out.println("usr= " + usr);
		return usr;
	}

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findByEmpId(int empId) {
		return userDao.findByEmpId(empId);
	}

	@Override
	public String login(int empId, String pass) {
	    UserDetails userDetails;
	    try {
	        userDetails = loadUserByUsername(String.valueOf(empId));
	    } catch (UsernameNotFoundException ex) {
	        throw new RuntimeException("User not found with empId: " + empId);
	    }
	    User user = userRepo.findByEmpId(empId);
	    if (user != null && bCryptPasswordEncoder.matches(pass, user.getPass())) {
	        if (user.isApproval()) {
	            Map<String, Object> claims = new HashMap<>();
	            claims.put("empId", user.getEmpId());
	            claims.put("uId", user.getuId());
	            claims.put("approval", user.isApproval());
	            String token = Jwts.builder()
	                    .setClaims(claims)
	                    .setIssuedAt(new Date())
	                    .setExpiration(new Date(System.currentTimeMillis() + 864000000))
	                    .signWith(SignatureAlgorithm.HS256, "secretkey")
	                    .compact();
	            return token;
	        } else {
	            throw new RuntimeException("User is not approved");
	        }
	    } else {
	        throw new RuntimeException("Invalid username or password");
	    }
	}


	@Override
	public void register(int empId, String pass, Employee empDetails) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
    public UserDetails loadUserByUsername(String empId) throws UsernameNotFoundException {
        User user = userRepo.findByEmpId(Integer.parseInt(empId));
        if (user == null) {
            throw new UsernameNotFoundException("User not found with empId: " + empId);
        }
        return org.springframework.security.core.userdetails.User.builder()
            .username(String.valueOf(user.getEmpId()))
            .password(user.getPass())
            .roles("USER")
            .build();
    }

}
