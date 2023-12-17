package com.rental.admin.service;

import java.util.List;


import com.rental.admin.domain.HouseRenter;
import com.rental.admin.domain.User;

public interface HouseRenterService {
	
	
	List<HouseRenter> findByUser(User user);

	Integer addRentCountToUser(User user);
	
	List<HouseRenter> findAll();
	
	Integer count();
	
	void deleteById(Integer id);
	
	void save(HouseRenter houseRenter);

}
