package com.valtech.poc.sms.service;

import com.valtech.poc.sms.entities.User;

public interface UserService {

	User findByEmail(String email);

}