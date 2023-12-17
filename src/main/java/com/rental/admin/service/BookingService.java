package com.rental.admin.service;

import java.util.List;

import com.rental.admin.domain.Booking;

public interface BookingService {

	Booking findByBookingId(Long bookingId);
	
	List<Booking> findAll();
	
	Booking saveBooking(Booking booking);
	
	void remove(Long bookingId);
}
