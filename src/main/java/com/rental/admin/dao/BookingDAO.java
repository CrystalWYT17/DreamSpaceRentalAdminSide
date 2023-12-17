package com.rental.admin.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rental.admin.domain.Booking;

public interface BookingDAO extends CrudRepository<Booking, Long> {

	Booking findByBookingId(Long bookingId);
	
	List<Booking> findAll();
}
