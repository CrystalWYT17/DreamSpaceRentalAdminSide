package com.rental.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.admin.dao.HouseTownshipDAO;
import com.rental.admin.domain.House;
import com.rental.admin.domain.HouseTownship;
import com.rental.admin.domain.Township;
import com.rental.admin.service.HouseTownshipService;

@Service
public class HouseTownshipServiceImpl implements HouseTownshipService {

	@Autowired
	HouseTownshipDAO houseTownshipDAO;


	

	@Override
	public HouseTownship findHouseByTownship(House house) {
		// TODO Auto-generated method stub
		return houseTownshipDAO.findTownshipByHouse(house);
	}

}
