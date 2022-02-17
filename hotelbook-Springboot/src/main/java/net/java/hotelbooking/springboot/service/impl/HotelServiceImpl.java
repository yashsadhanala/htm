package net.java.hotelbooking.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.java.hotelbooking.springboot.repository.HotelRepository;
import net.java.hotelbooking.springboot.exception.ResourceNotFoundException;
import net.java.hotelbooking.springboot.model.Hotel;
import net.java.hotelbooking.springboot.service.HotelService;
@Service
public class HotelServiceImpl implements HotelService {


public HotelRepository hotelRepository;
	
	public HotelServiceImpl(HotelRepository hotelRepository) {
		super();
		this.hotelRepository = hotelRepository;
	}

	@Override
	public Hotel saveHotel(Hotel hotel) {
	     hotel.setRoomsavailable(hotel.getTotalrooms()); 
	     return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();

	}

	@Override
	public Hotel getHotelById(long hotel_id) {
		List<Hotel> h =  hotelRepository.findAllByHotelId(hotel_id);
		if(h.size()==0) {
			return null;
		}
		return h.get(0);

	}

	@Override
	public Hotel updateHotel(Hotel hotel, long hotel_id) {
		Hotel existingHotel = hotelRepository.findById(hotel_id).orElseThrow(()-> new ResourceNotFoundException("Hotel","Hotel_id",hotel_id));
		existingHotel.setHotelname(hotel.getHotelname());
		existingHotel.setCity(hotel.getCity());
		existingHotel.setTotalrooms(hotel.getTotalrooms());
		existingHotel.setRoomsavailable(hotel.getTotalrooms());
		hotelRepository.save(existingHotel);
		return existingHotel;
	}

	@Override
	public void deleteHotel(long hotel_id) {
		hotelRepository.findById(hotel_id).orElseThrow(()->
		new ResourceNotFoundException("Hotel","Hotel_id",hotel_id));
        hotelRepository.deleteById(hotel_id);
		
	}


}
