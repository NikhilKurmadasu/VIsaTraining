package com.visa.prj.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.prj.entity.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Integer> {

	List<Hotel> findByCity(String city);
	
	@Query("from Hotel h where h.price between :low and :high")
	List<Hotel> getByPriceRange(@Param("low") BigDecimal lower,@Param("high") BigDecimal higher);
}
