package com.valtech.poc.sms.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.poc.sms.dao.SeatBookingDao;
@Service

public class SeatBookingServiceImpl implements SeatBookingService {
	
	@Autowired
	 private SeatBookingDao seatBookingDao;
	
	@Override
    public List<Integer> getAllSeats() {
        return seatBookingDao.getAllSeats();
    }

}
