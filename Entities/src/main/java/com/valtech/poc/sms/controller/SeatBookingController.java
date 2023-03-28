package com.valtech.poc.sms.controller;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.poc.sms.entities.Employee;
import com.valtech.poc.sms.entities.Seat;
import com.valtech.poc.sms.entities.SeatsBooked;
import com.valtech.poc.sms.service.EmployeeService;
import com.valtech.poc.sms.service.SeatBookingService;

@RestController
@RequestMapping("/seats")
public class SeatBookingController {

    @Autowired
    private SeatBookingService seatService;
    
    @Autowired
    private EmployeeService employeeService;
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
    @ResponseBody
    @GetMapping("/employees/{id}")
      public ResponseEntity<List<SeatsBooked>> findEmployeeWiseSeatsBooked(@PathVariable("id") int empId) {
         Employee emp = employeeService.getEmployeeByeId(empId);      
         List<SeatsBooked> seatsBookedList = seatService.findEmployeeWiseSeatsBooked(emp);
           if (seatsBookedList.isEmpty()) {
              return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
           return new ResponseEntity<>(seatsBookedList, HttpStatus.OK);
        }
    
    
    @GetMapping("/available/{date}")
       public ResponseEntity<List<Seat>> getAvailableSeatsByDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
         List<Seat> availableSeats = seatService.findAvailableSeatsByDate(date);
             if (availableSeats.isEmpty()) {
                 return ResponseEntity.noContent().build();
                        }
                 return ResponseEntity.ok(availableSeats);
       }
 
    @PostMapping("/book")
       public ResponseEntity<String> bookSeat(@RequestBody SeatsBooked seatsBooked) {
        try {
        	seatService.bookSeat(seatsBooked);
            return new ResponseEntity<>("Seat booked successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to book seat", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}


//@GetMapping("/seats/count")
//public ResponseEntity<Integer> getTotalSeatsCount() {
//    int totalSeatsCount = seatBookingService.countTotalSeats();
//    return ResponseEntity.ok(totalSeatsCount);
//}