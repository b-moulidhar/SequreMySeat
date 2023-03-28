package com.valtech.poc.sms.service;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.poc.sms.dao.SeatBookingDao;
import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.entities.Seat;
import com.valtech.poc.sms.entities.SeatsBooked;
import com.valtech.poc.sms.repo.SeatsBookedRepo;

@Service
public class SeatBookingServiceImpl implements SeatBookingService
{
	
	@Autowired
	 private SeatBookingDao seatBookingDao;
	
	@Autowired
	private SeatsBookedRepo seatsBookedRepo;
	
	@Override
    public List<Integer> getAllSeats() {
        return seatBookingDao.getAllSeats();
    }
//	
	@Override
	public List<Integer> availableSeats() {
		return seatBookingDao.availableSeats();
	}
		
	@Override
    public List<Integer> countTotalSeats() {
        return seatBookingDao.countTotalSeats();
    }
//	@Override
//	public List<Integer> getSeatById() {
//		// TODO Auto-generated method stub
//		return null;
//	}



//	@Override
//	public List<Seat> findAvailableSeats() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
//	@Override
//	public List<Seat> findAvailableSeats() {
//        return seatBookingDao.findByBooked(false);
//    }
	@Override
	public List<SeatsBooked> findEmployeeWiseSeatsBooked(Employee emp)	{
		return seatsBookedRepo.findAllByeId(emp);
	}


	
}
