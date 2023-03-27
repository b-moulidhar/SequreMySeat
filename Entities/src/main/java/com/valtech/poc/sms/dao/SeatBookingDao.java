package com.valtech.poc.sms.dao;

import java.util.List;

import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.entities.Seat;
import com.valtech.poc.sms.entities.SeatsBooked;

public interface SeatBookingDao {

	List<Integer> getAllSeats();

	

//	List<Seat> findByBooked(boolean booked);



	List<Integer> availableSeats();



	List<SeatsBooked> findAllByEId(Employee emp);



	SeatsBooked findCurrentSeat(Employee emp);

}