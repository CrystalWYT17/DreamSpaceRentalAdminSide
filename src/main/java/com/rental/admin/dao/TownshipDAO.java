package com.rental.admin.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rental.admin.domain.Township;

public interface TownshipDAO extends CrudRepository<Township, Integer>{

	List<Township> findAll();
	
	Township findByTownshipName(String townshipName);
}
