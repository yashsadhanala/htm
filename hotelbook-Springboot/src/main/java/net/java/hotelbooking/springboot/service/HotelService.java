package net.java.hotelbooking.springboot.service;

import java.util.List;

import net.java.hotelbooking.springboot.model.Hotel;

public interface HotelService {
	Hotel saveHotel(Hotel hotel);
	List <Hotel>getAllHotels();
	Hotel getHotelById(long hotel_id);
	Hotel updateHotel(Hotel hotel,long hotel_id);
	void deleteHotel(long hotel_id);
}
