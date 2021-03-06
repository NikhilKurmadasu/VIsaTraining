package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Booking;
import com.visa.prj.service.BookingService;

@RestController
public class BookingContoller {

	@Autowired
	private BookingService bookingService;
	
	@GetMapping("bookings")
	public @ResponseBody List<Booking> getBookings(){
		return bookingService.getBookings();
	}
	@PostMapping("bookings")
	public ResponseEntity<Booking> createBooking(@RequestBody Booking b){
		bookingService.createBooking(b);
		return new ResponseEntity<Booking>(b,HttpStatus.CREATED);
	}
}
