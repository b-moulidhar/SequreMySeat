package com.valtech.poc.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
//    @PostMapping("/book-seat")
//    public ResponseEntity<String> bookSeat() {
//        int seatNumber = seatService.bookSeat();
//        if (seatNumber != 0000) {
//        	 return ResponseEntity.ok("Seat " + seatNumber + " booked");
//        } else {
//         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No seats available");
//         
//        }
//    }

        
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
