package com.valtech.poc.sms.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.poc.sms.dao.SeatBookingDao;
import com.valtech.poc.sms.entities.Seat;

@Service

public  class SeatBookingServiceImpl implements SeatBookingService {
	
	@Autowired
	 private SeatBookingDao seatBookingDao;
	
	@Override
    public List<Integer> getAllSeats() {
        return seatBookingDao.getAllSeats();
    }
	
	@Override
	public List<Integer> availableSeats() {
		return seatBookingDao.availableSeats();
		
		
	}

	@Override
	public List<Seat> findAvailableSeats() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	public List<Seat> findAvailableSeats() {
//        return seatBookingDao.findByBooked(false);
//    }

}
