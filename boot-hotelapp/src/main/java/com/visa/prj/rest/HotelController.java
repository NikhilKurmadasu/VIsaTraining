package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Hotel;
import com.visa.prj.service.HotelService;

@RestController
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@GetMapping("hotels")
	public @ResponseBody List<Hotel> getHotels(@RequestParam(name = "city", required = false) String city) {
		if (city == null) {
			return hotelService.getHotels();
		} else {
			return hotelService.getHotelsByCity(city);
		}

	}
	
	@PostMapping("hotels")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel h) {
		hotelService.addHotel(h);
		return new ResponseEntity<>(h, HttpStatus.CREATED);
	}

	@GetMapping("hotels/{id}")
	public @ResponseBody Hotel getProduct(@PathVariable("id") int id) {
		return hotelService.getHotels().stream().filter(h -> h.getId() == id).findFirst().get();
	}
}
