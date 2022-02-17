package net.java.hotelbooking.springboot.service;


import net.java.hotelbooking.springboot.model.Booking;


public interface BookingService {
	Booking saveBooking(Booking booking);
    String cancelBooking(long booking_id);
}
