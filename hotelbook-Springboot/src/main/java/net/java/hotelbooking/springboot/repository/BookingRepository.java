package net.java.hotelbooking.springboot.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.java.hotelbooking.springboot.model.Booking;
@Repository
@Transactional
public interface BookingRepository extends JpaRepository<Booking,Long> {
//
    void deleteAllByBooking_id(long booking_id);

	List<Booking> findAllByHotelIdAndCancelAndCheckIn(long hotel_id, int cancel, String checkin);

	List<Booking> findAllByBookingIdAndCancel(long booking_id,int cancel);
	
	//Booking findByBooking_id(long booking_id);


}
