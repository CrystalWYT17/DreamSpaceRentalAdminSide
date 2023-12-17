package com.rental.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.admin.dao.BookingDAO;
import com.rental.admin.domain.Booking;
import com.rental.admin.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDAO bookingDAO;
	
	@Override
	public Booking findByBookingId(Long bookingId) {
		// TODO Auto-generated method stub
		Booking booking = bookingDAO.findByBookingId(bookingId);
		return booking;
	}

	@Override
	public List<Booking> findAll() {
		// TODO Auto-generated method stub
		return bookingDAO.findAll();
	}

	@Override
	public Booking saveBooking(Booking booking) {
		// TODO Auto-generated method stub
		return bookingDAO.save(booking);
	}

	@Override
	public void remove(Long bookingId) {
		// TODO Auto-generated method stub
		bookingDAO.deleteById(bookingId);
	}

}
