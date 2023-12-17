package com.rental.admin.service;

import java.util.List;

import com.rental.admin.domain.HouseAgentSample;

public interface HouseAgentSampleService {
	
	List<HouseAgentSample> findAll();

	void save(HouseAgentSample hs);
	
	void deleteById(Long id);
	
	HouseAgentSample findByHouseId(Long houseId);
}
