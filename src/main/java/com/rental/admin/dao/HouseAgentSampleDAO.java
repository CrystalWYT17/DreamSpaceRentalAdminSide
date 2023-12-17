package com.rental.admin.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rental.admin.domain.HouseAgentSample;

public interface HouseAgentSampleDAO extends CrudRepository<HouseAgentSample, Long>{

	HouseAgentSample findByHouseId(Long houseId);
	
}
