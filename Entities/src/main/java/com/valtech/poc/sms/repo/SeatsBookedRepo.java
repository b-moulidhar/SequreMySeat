package com.valtech.poc.sms.repo;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.entities.SeatsBooked;

import jakarta.transaction.Transactional;

public interface SeatsBookedRepo extends JpaRepository<SeatsBooked, Integer>{
	
	@Transactional
    @Modifying
    
	List<SeatsBooked> findAllByeId(Employee emp);

	    @Query("UPDATE SeatBooking sb SET sb.notifStatus = false WHERE sb.sbId = :sbId")
	    void notifStatus(@Param("sbId") int sbId);

	}



