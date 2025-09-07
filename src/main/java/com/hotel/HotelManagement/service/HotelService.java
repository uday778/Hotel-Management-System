package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.Dto.UpdateHotelAddressDTO;
import com.hotel.HotelManagement.communicator.RestTemplateCommunicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.HotelManagement.Dto.HotelDTO;
import com.hotel.HotelManagement.entity.Hotel;
import com.hotel.HotelManagement.repository.HotelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;

    @Autowired
    private RestTemplateCommunicator restTemplateCommunicator;
	
	public ResponseEntity<Hotel> saveHotel(HotelDTO hotelDto) {
		Hotel hotel=new Hotel();
		hotel.setName(hotelDto.getName());
        hotel.setCity(hotelDto.getCity());
        hotel.setAddress(hotelDto.getAddress());
        hotel.setPostalCode(hotelDto.getPostalCode());
        hotel.setRating(hotelDto.getRating());
        hotel.setAvailable(hotelDto.isAvailable());


        hotelRepository.save(hotel);
        return new ResponseEntity<>(hotel,HttpStatus.CREATED);
	    
		
		
	}

    public List<Hotel> getAllHotels() {
     return hotelRepository.findAll();
    }




    public ResponseEntity<Hotel> getHotelById(Long id) {
        Optional<Hotel> hotelBox = hotelRepository.findById(id);

        if (hotelBox.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Hotel hotel = hotelBox.get();

        try {
            Float hotelActualRating = restTemplateCommunicator.getActualHotelRating(id);
            if (hotelActualRating != null) {
                hotel.setRating(hotelActualRating);
            }
        } catch (Exception e) {
            // log error and continue
            System.err.println("Failed to fetch rating for hotel " + id + ": " + e.getMessage());
        }

        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }



    public ResponseEntity<Hotel> updateHotel(HotelDTO hotelDTO,Long id) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);

        if(optionalHotel.isPresent()){
            Hotel hotel = optionalHotel.get();
            hotel.setName(hotelDTO.getName());
            hotel.setCity(hotelDTO.getCity());
            hotel.setAddress(hotelDTO.getAddress());
            hotel.setPostalCode(hotelDTO.getPostalCode());
            hotel.setRating(hotelDTO.getRating());
            hotel.setAvailable(hotelDTO.isAvailable());
            hotelRepository.save(hotel) ;
            return new  ResponseEntity<>(hotel,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public boolean deleteHotel(Long id) {
        if (hotelRepository.existsById(id)) {
            hotelRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Hotel updateHotelAddress(UpdateHotelAddressDTO dto, Long id) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);

        if (hotel != null) {
            hotel.setCity(dto.getCity());
            hotel.setAddress(dto.getAddress());
            hotel.setPostalCode(dto.getPostalCode());
            return hotelRepository.save(hotel);
        }
        return null;
    }


}
