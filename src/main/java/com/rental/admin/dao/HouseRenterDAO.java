package com.rental.admin.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rental.admin.domain.HouseRenter;
import com.rental.admin.domain.User;

public interface HouseRenterDAO extends CrudRepository<HouseRenter, Integer>{

	
	List<HouseRenter> findByUser(User user);
	
	List<HouseRenter> findAll();
}
