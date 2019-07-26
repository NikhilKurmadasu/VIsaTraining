package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Ticket;
import com.visa.prj.service.TicketService;


@RestController
public class TicketController {

	@Autowired
	private TicketService service;
	
	@GetMapping("/tickets")
	public @ResponseBody List<Ticket> getTickets(){
		return service.getTickets();
	}
	
	@PostMapping("/ticket")
	public ResponseEntity<Ticket> createTicket(@RequestBody Ticket t){
		service.createTicket(t);
		return new ResponseEntity<Ticket>(t,HttpStatus.CREATED);
	}
	@PostMapping("tickets/log")
	public ResponseEntity<Ticket> logTicket(@RequestBody Ticket t) {
		service.createTicket(t);
		return new ResponseEntity<Ticket>(t, HttpStatus.CREATED);
	}
	
	@PutMapping("tickets/resolve")
	public ResponseEntity<Ticket> resolveTicket(@RequestBody Ticket t) {
		Ticket t1 = service.getTicketById(t.getId());
		System.out.println(t1);
		t1.setResolvedBy(t.getResolvedBy());
		t1.setResolvedDate(t.getResolvedDate());
		t1.setResolvedInfo(t.getResolvedInfo());
		service.createTicket(t1);
		return new ResponseEntity<Ticket>(t1, HttpStatus.CREATED);
	} 
}
