package com.valtech.poc.sms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.poc.sms.entities.User;

public interface UserepoTemp extends JpaRepository<User, Integer> {

	List<User> findAll();

}
