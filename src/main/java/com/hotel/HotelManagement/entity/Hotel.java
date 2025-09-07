package com.hotel.HotelManagement.entity;

import org.springframework.stereotype.Service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter

public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	 private String name;
	 private String address;
	 private int postalCode;
	 private String city;
	 private float rating;
	 @Column(name="available")
	 private boolean isAvailable;
	 
	 
}
