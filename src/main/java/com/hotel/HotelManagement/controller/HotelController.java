package com.hotel.HotelManagement.controller;

import com.hotel.HotelManagement.Dto.UpdateHotelAddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hotel.HotelManagement.Dto.HotelDTO;
import com.hotel.HotelManagement.entity.Hotel;
import com.hotel.HotelManagement.service.HotelService;

import java.util.List;

@RestController
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	
	@PostMapping("/createhotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody HotelDTO hotelDto ) {
		return hotelService.saveHotel(hotelDto);
	}

    @GetMapping("/getallhotels")
    public List<Hotel> getAllHotels(){
        return hotelService.getAllHotels();
    }

    @GetMapping("/gethotel/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id){
        return hotelService.getHotelById(id);
    }

    @PutMapping("/updatehotel/{id}")
    public  ResponseEntity<Hotel> updateHotel(@RequestBody HotelDTO hotelDTO,@PathVariable Long id){
       return  hotelService.updateHotel(hotelDTO,id);
    }

    @DeleteMapping("/deletehotel/{id}")
    public  ResponseEntity<Void> deleteHotel(@PathVariable Long id){
        boolean deletedHotel=hotelService.deleteHotel(id);
        if (deletedHotel) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204, successful delete, no body
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404, hotel not found
        }
    }

    @PutMapping("/updatehoteladdress/{id}")
    public ResponseEntity<Hotel> updateHotelAddress(@RequestBody UpdateHotelAddressDTO updateHotelAddressDTO, @PathVariable Long id){
        Hotel updatedHotel = hotelService.updateHotelAddress(updateHotelAddressDTO, id);
        if (updatedHotel != null) {
            return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





}
