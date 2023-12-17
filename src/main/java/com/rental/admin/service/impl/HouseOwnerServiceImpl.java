package com.rental.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.admin.dao.HouseOwnerDAO;
import com.rental.admin.domain.HouseOwner;
import com.rental.admin.domain.User;
import com.rental.admin.service.HouseOwnerService;

@Service
public class HouseOwnerServiceImpl implements HouseOwnerService {
	
	@Autowired
	private HouseOwnerDAO houseOwnerDAO;

	@Override
	public List<HouseOwner> findByUser(User user) {
		// TODO Auto-generated method stub
		return houseOwnerDAO.findByUser(user);
	}

	@Override
	public Integer addOwnedCountToUser(User user) {
		// TODO Auto-generated method stub
		
Integer owned = 0;
		
		List<HouseOwner> houseOwnedList = findByUser(user);
		
		List<Long> houseOwnerList = new ArrayList<>();
		
		for(HouseOwner houseOwner: houseOwnedList) {
			
			Long houseOwnerId = houseOwner.getHouse().getHouseId();
			
			
			
			houseOwnerList.add(houseOwnerId);
			
			owned = houseOwnerList.size();
		
		}
		
		
		return owned;
	}
	}


