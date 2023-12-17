package com.rental.admin.service;

import java.util.List;
import java.util.Set;

import com.rental.admin.domain.House;
import com.rental.admin.domain.HouseAgent;
import com.rental.admin.domain.HouseImage;
import com.rental.admin.domain.HouseOwner;
import com.rental.admin.domain.HouseRenter;

public interface HouseService {
	
	House findById(Long houseId);
	
	House saveHouse(House house,HouseOwner houseOwner);
	
	void saveHouseImage(House house,Set<HouseImage> houseImage);
	
	List<House> findAll();
	
	Integer count();
	
	void deleteHouseAgent(Long houseAgentId);
	
	void saveHouseAgent(HouseAgent houseAgent);
	
	void saveHouseRenter(HouseRenter houseRenter);
	
	House findByAddress(String address);
	
	void deleteHouseRenter(HouseRenter houseRenter);
	
	List<HouseImage> findByHouse(House house);
	
	void saveHouseOwner(HouseOwner houseOwner);
	
	void delete(House house);

}
