package com.valtech.poc.sms.service;

import java.util.List;

import com.valtech.poc.sms.entities.Seat;

public interface SeatBookingService {

	List<Integer> getAllSeats();

	//List<Seat> findAvailableSeats();

	List<Integer> availableSeats();
//
//	int totalSeats();

	List<Integer> countTotalSeats();

	//List<Integer> getSeatById();

}