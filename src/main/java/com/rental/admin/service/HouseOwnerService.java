package com.rental.admin.service;

import java.util.List;

import com.rental.admin.dao.HouseOwnerDAO;
import com.rental.admin.domain.HouseOwner;
import com.rental.admin.domain.User;

public interface HouseOwnerService {

	List<HouseOwner> findByUser(User user);
	
	Integer addOwnedCountToUser(User user);
	
}
