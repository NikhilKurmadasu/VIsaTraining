package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.HotelDao;
import com.visa.prj.entity.Hotel;

@Service
public class HotelService {

	@Autowired
	private HotelDao hotelDao;
	
	@Transactional
	public void addHotel(Hotel h) {
		hotelDao.save(h);
	}

	public List<Hotel> getHotels() {
		return hotelDao.findAll();
	}
	
	public List<Hotel> getHotelsByCity(String city) {
		return hotelDao.findByCity(city);

}
}
