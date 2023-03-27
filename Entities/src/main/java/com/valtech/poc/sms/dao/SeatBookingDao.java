package com.valtech.poc.sms.dao;

import java.util.List;

import com.valtech.poc.sms.entities.Seat;

public interface SeatBookingDao {

//	List<Integer> getAllSeats();

	List<Integer> availableSeats();

   List<Integer> countTotalSeats();

List<Integer> getAllSeats();

//List<Integer> getSeatById();




}