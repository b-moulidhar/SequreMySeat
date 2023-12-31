package com.valtech.poc.sms.service;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.entities.Seat;
import com.valtech.poc.sms.entities.SeatsBooked;

public interface SeatBookingService {

	List<Integer> getAllSeats();

	//List<Seat> findAvailableSeats();

	List<Integer> availableSeats();
//
//	int totalSeats();

	List<Integer> countTotalSeats();

	//List<Integer> getSeatById();

//	List<SeatsBooked> findEmployeeWiseSeatsBooked(Employee emp);

	SeatsBooked findCurrentSeatBookingDetails(Employee emp);

	List<Seat> findAvailableSeats();

	List<SeatsBooked> findAllByEId(Employee emp);

	List<Seat> findAvailableSeatsByDate(LocalDate date);

	void bookSeat(SeatsBooked seatsBooked);

	SeatsBooked saveSeatsBookedDetails(SeatsBooked seatsBooked);

	//void updateNotifStatus(int sbId);

	void notifStatus(int sbId);

	//void updateNotifStatus(int sbId, Connection connection);

//	void bookSeat();

//	void bookSeat(SeatsBooked seatsBooked);

}