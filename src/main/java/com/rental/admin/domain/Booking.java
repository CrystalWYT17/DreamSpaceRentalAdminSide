package com.rental.admin.domain;

/**
 * @author ThetHninSu
 */

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingId;
	
	private String customerName;
	private String phoneNo;
	private String email;
	private String expectedTime;
	private Date expectedDate;
	private Boolean approve;
	private Long houseId;
	
	@OneToMany(mappedBy = "booking",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnore
	private List<BookingUser> bookingUserList;
	
	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Long getHouseId() {
		return houseId;
	}

	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}

	public List<BookingUser> getBookingUserList() {
		return bookingUserList;
	}

	public void setBookingUserList(List<BookingUser> bookingUserList) {
		this.bookingUserList = bookingUserList;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExpectedTime() {
		return expectedTime;
	}

	public void setExpectedTime(String expectedTime) {
		this.expectedTime = expectedTime;
	}

	public Date getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}

	public Boolean getApprove() {
		return approve;
	}

	public void setApprove(Boolean approve) {
		this.approve = approve;
	}
}
