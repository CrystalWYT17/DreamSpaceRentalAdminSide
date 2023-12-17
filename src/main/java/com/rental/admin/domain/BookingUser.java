package com.rental.admin.domain;

/**
 * @author ThetHninSu
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class BookingUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingUserId;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "houseId")
	private House house;
	
	@OneToOne
	@JoinColumn(name = "bookingId")
	private Booking booking;
	
	public BookingUser() {
		// TODO Auto-generated constructor stub
	}

	public Long getBookingUserId() {
		return bookingUserId;
	}

	public void setBookingUserId(Long bookingUserId) {
		this.bookingUserId = bookingUserId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
}
