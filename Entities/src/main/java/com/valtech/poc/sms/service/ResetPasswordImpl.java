package com.valtech.poc.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.poc.sms.entities.User;
import com.valtech.poc.sms.repo.UserepoTemp;

@Service
public class ResetPasswordImpl {
	
	@Autowired
	UserepoTemp userRepo;
	
	
//	@Override
	public boolean checkMailId(String email) {
		List<User> allUsers = userRepo.findAll();
		System.out.println(allUsers);
		for(User user1:allUsers) {
			String s1= "{\"email\":\""+user1.getEmpDetails().getMailId()+"\"}";
			if(email.equals(user1.getEmpDetails().getMailId())) {
				return true;
			}
		}
		return false;
	}

}
