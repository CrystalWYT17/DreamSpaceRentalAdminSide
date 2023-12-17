package com.rental.admin.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rental.admin.domain.House;
import com.rental.admin.domain.HouseImage;

public interface HouseImageDAO extends CrudRepository<HouseImage, Integer>{

	List<HouseImage> findByHouse(House house);
	
}
