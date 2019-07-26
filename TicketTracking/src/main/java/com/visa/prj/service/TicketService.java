package com.visa.prj.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.TicketDao;
import com.visa.prj.entity.Ticket;

@Service
public class TicketService {

	@Autowired
	private TicketDao ticketDao;
	
	@Transactional
	public void createTicket(Ticket t) {
		ticketDao.save(t);
	}
	
	public List<Ticket> getTickets(){
		return ticketDao.findAll();
	}

	public Ticket getTicketById(int id) {
		return ticketDao.findByid(id);
	}
}
