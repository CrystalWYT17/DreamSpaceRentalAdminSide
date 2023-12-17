package com.rental.admin.service;

import java.util.List;

import com.rental.admin.domain.Township;

public interface TownshipService {

	Township save(Township township);
	
	Township update(Township township);
	
	List<Township> findAll();
	
	Township findById(Integer townshipId);
	
	void removeOne(Integer townshipId);
	
	Township findByTownshipName(String townshipName);
}
