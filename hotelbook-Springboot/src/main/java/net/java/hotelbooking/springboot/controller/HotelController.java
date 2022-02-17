package net.java.hotelbooking.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.java.hotelbooking.springboot.model.Hotel;
import net.java.hotelbooking.springboot.service.HotelService;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
	
	private HotelService hotelService;

	
	public HotelController(HotelService hotelService) {
		super();
		this.hotelService = hotelService;
	}
	@PostMapping()
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){

		return new ResponseEntity<Hotel>(hotelService.saveHotel(hotel),HttpStatus.CREATED);
		
}
	@GetMapping()
	public List<Hotel> getAllHotels(){
		return hotelService.getAllHotels();	}

	
	@GetMapping("{hotel_id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable("hotel_id") long hotel_id){
		return new ResponseEntity<Hotel>(hotelService.getHotelById(hotel_id),HttpStatus.OK);
	}
	
	
	@PutMapping("{hotel_id}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable("hotel_id") long hotel_id, @RequestBody Hotel hotel){
		return new ResponseEntity<Hotel>(hotelService.updateHotel(hotel, hotel_id),HttpStatus.OK);
	}


	
	@DeleteMapping("{hotel_id}")
	public ResponseEntity<String> deleteHotel(@PathVariable("hotel_id")long hotel_id){
			hotelService.deleteHotel(hotel_id);
			return new ResponseEntity<String>("Hotel Deleted succesfully!.",HttpStatus.OK);
	}
	

}

