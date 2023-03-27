package com.valtech.poc.sms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.entities.SeatsBooked;

public interface SeatsBookedRepo extends JpaRepository<SeatsBooked, Integer>{
	
	List<SeatsBooked> findAllByeId(Employee emp);

}
