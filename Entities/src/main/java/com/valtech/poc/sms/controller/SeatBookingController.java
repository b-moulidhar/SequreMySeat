package com.valtech.poc.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.poc.sms.service.SeatBookingService;

@RestController
@RequestMapping("/seats")
public class SeatBookingController {

    @Autowired
    private SeatBookingService seatService;
//
    @GetMapping("/total")
    public ResponseEntity<List<Integer>> getAllSeats() {
        List<Integer> allSeats = seatService.getAllSeats();
        return ResponseEntity.ok().body(allSeats);
    }
//        
    @GetMapping("/available")
    public ResponseEntity<List<Integer>> availableSeats() {
    	List<Integer> availableSeats = seatService.availableSeats();
    	return ResponseEntity.ok().body(availableSeats);
    	
    }

    @GetMapping("/count")
    public ResponseEntity<List<Integer>> getTotalSeatsCount() {
    	List<Integer> totalSeats = seatService.countTotalSeats();
		return ResponseEntity.ok().body(totalSeats);
    	
    }
        
//    @GetMapping("/id")
//    public ResponseEntity<List<Integer>> getSeatById() {
//    	List<Integer> seatId = seatService.getSeatById();
//    	return ResponseEntity.ok().body(seatId);
//    }
}

//@GetMapping("/seats/count")
//public ResponseEntity<Integer> getTotalSeatsCount() {
//    int totalSeatsCount = seatBookingService.countTotalSeats();
//    return ResponseEntity.ok(totalSeatsCount);
//}
