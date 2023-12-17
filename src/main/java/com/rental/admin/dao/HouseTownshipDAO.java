package com.rental.admin.dao;

import org.springframework.data.repository.CrudRepository;

import com.rental.admin.domain.House;
import com.rental.admin.domain.HouseTownship;
import com.rental.admin.domain.Township;

public interface HouseTownshipDAO extends CrudRepository<HouseTownship, Integer> {
	
	HouseTownship findTownshipByHouse(House house);
	
	
}
