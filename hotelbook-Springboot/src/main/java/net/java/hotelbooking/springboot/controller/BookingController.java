package net.java.hotelbooking.springboot.controller;

import java.text.DateFormat;
//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import lombok.extern.slf4j.Slf4j;
import net.java.hotelbooking.springboot.model.Booking;
import net.java.hotelbooking.springboot.service.BookingService;



@RestController
@RequestMapping("/api/booking/")
public class BookingController {

    @Autowired
    private BookingService bookingService;
	//private Object log;

//    public BookingController(BookingService bookingService) {
//		super();
//		this.bookingService = bookingService;
//	}

	@PostMapping("/a")
    public ResponseEntity<Booking> saveBooking1(@RequestParam(name = "hotel_id") int hotel_id,
                                                @RequestParam(name = "checkin") Date checkin) {
        System.out.println("Running........");
        Booking booking = new Booking();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(checkin);
        booking.setHotelId(hotel_id);
        booking.setCheckin(strDate);
        
     //	log.info("New booking request received on " + booking.getCheckin() + " for hotel Id " + booking.getHotelId());
    
    //    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
 
//            if (date1.after(date)) {
//                throw new InvalidDateFormat("Please Enter date after " + date);
//            }

//        } catch (Exception e) {
//            throw new InvalidDateFormat();
//        }

        ResponseEntity<Booking> res = new ResponseEntity<Booking>(bookingService.saveBooking(booking), HttpStatus.CREATED);
//        if (res.getBody() == null)
//            throw new NoHotelFound();
        return res;
    }

    @PostMapping
    public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking) {

//        boolean b = true;
//        String s = "";
//        s = booking.getCheckout();
//        if (booking.getCheckout() == null) {
//            b = false;
//        }
//        booking.setCheckout(null);

    //    log.info("New booking request received on " + booking.getCheckin() + " for hotel Id " + booking.getHotelId());
 
        //    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(booking.getCheckin());
           // Date date1 = new Date();
//            if (date1.after(date)) {
//                throw new InvalidDateFormat("Please Enter date after " + date);
//            }
//
//        } catch (Exception e) {
//            throw new InvalidDateFormat();
//        }

        ResponseEntity<Booking> res = new ResponseEntity<Booking>(bookingService.saveBooking(booking), HttpStatus.CREATED);
//        if (b) {
//            res.getBody().setCheckout(s);
//        }
//
//        if (res.getBody() == null)
//            throw new NoHotelFound();
        return res;
    }

    @DeleteMapping("{booking_id}")
    public ResponseEntity<String> cancelBooking(@PathVariable("booking_id") long booking_id) {
        //log.info("Booking cancellation request received  with booking Id:- " + booking_id);

        String s = bookingService.cancelBooking(booking_id);
        s = s + booking_id;
     //   log.info(s);
        return new ResponseEntity<String>(s, HttpStatus.OK);
    }

    @PutMapping("{booking_id}")
    public ResponseEntity<String> updateBooking(@PathVariable("booking_id") long booking_id) {
        String s = bookingService.cancelBooking(booking_id);

        return new ResponseEntity<String>(s, HttpStatus.OK);
    }
}

