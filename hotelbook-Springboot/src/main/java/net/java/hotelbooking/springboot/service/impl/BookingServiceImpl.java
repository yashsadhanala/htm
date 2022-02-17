package net.java.hotelbooking.springboot.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.java.hotelbooking.springboot.model.Booking;
import net.java.hotelbooking.springboot.model.Hotel;
import net.java.hotelbooking.springboot.repository.BookingRepository;
import net.java.hotelbooking.springboot.repository.HotelRepository;
import net.java.hotelbooking.springboot.service.BookingService;


@Service
public class BookingServiceImpl implements BookingService {

	@Autowired	
	public BookingRepository bookingRepository;

	@Autowired
	public HotelRepository hotelRepository;

//	public BookingServiceImpl(BookingRepository bookingRepository, HotelRepository hotelRepository) {
//		super();
//		this.bookingRepository = bookingRepository;
//		this.hotelRepository = hotelRepository;
//	}
	//@SuppressWarnings("unused")
	@Override
	public Booking saveBooking(Booking booking) {
		booking.setCancel(0);
		List<Hotel> h =  hotelRepository.findAllByHotelId(booking.getHotelId());
		Hotel hotel = h.get(0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        booking.setCheckout(sdf.format(c.getTime()));
        Booking booking_dummy = null;
        booking_dummy = bookingRepository.save(booking);
        return booking_dummy;
	}


	@Override
	public String cancelBooking(long booking_id) {
      List<Booking> bookingList = bookingRepository.findAllByBookingIdAndCancel(booking_id,0);
      String s;
      if (bookingList.size() == 0) {
          s = "Booking Id doesn't exist Id:- ";
      } else {
          bookingList.get(0).setCancel(1);
          bookingRepository.save(bookingList.get(0));
          s = "Booking Cancelled Id:- ";
      }
      return s;
	
	}

}
