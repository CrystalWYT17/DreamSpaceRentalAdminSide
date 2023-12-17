package com.rental.admin.dao;

import org.springframework.data.repository.CrudRepository;

import com.rental.admin.domain.House;

public interface HouseDAO extends CrudRepository<House, Long>{

	House findByAddress(String address);
	
}
