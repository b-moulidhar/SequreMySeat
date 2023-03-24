package com.valtech.poc.sms.dao;

import java.util.List;

import com.valtech.poc.sms.entities.Seat;

public interface SeatBookingDao {

	List<Integer> getAllSeats();

	

//	List<Seat> findByBooked(boolean booked);



	List<Integer> availableSeats();

}