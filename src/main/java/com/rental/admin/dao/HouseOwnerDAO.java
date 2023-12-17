package com.rental.admin.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rental.admin.domain.HouseOwner;
import com.rental.admin.domain.User;





public interface HouseOwnerDAO extends CrudRepository<HouseOwner, Integer> {
	
	List<HouseOwner> findByUser(User user);
	

}
