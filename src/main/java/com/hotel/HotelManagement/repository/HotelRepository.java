package com.hotel.HotelManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.HotelManagement.Dto.HotelDTO;
import com.hotel.HotelManagement.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long>{

	
	

}
