package com.rental.admin.service;

import com.rental.admin.domain.House;
import com.rental.admin.domain.HouseTownship;
import com.rental.admin.domain.Township;

public interface HouseTownshipService {
	
	
	
	HouseTownship findHouseByTownship(House houseName);
}
