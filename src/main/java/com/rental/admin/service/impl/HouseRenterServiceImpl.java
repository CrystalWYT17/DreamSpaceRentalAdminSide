package com.rental.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.admin.dao.HouseRenterDAO;
import com.rental.admin.domain.HouseRenter;
import com.rental.admin.domain.User;
import com.rental.admin.service.HouseRenterService;

@Service
public class HouseRenterServiceImpl implements HouseRenterService{

	
	@Autowired
	private HouseRenterDAO houseRenterDAO;

	@Override
	public Integer addRentCountToUser(User user) {
		// TODO Auto-generated method stub
		
		
		Integer rent = 0;
		
		List<HouseRenter> houseRentList = findByUser(user);
		
		List<Long> houseRenterList = new ArrayList<>();
		
		for(HouseRenter houseRenter: houseRentList) {
			
			if(houseRenter.getEnabled()) {
				Long houseRentId = houseRenter.getHouse().getHouseId();
				
				
				
				houseRenterList.add(houseRentId);
				
				 rent = houseRenterList.size();
			}
			
		}
		
		
		return rent;
	}




	@Override
	public List<HouseRenter> findByUser(User user) {
		// TODO Auto-generated method stub
		return houseRenterDAO.findByUser(user);
	}




	@Override
	public List<HouseRenter> findAll() {
		// TODO Auto-generated method stub
		return houseRenterDAO.findAll();
	}




	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return (int) houseRenterDAO.count();
	}




	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		houseRenterDAO.deleteById(id);
	}




	@Override
	public void save(HouseRenter houseRenter) {
		// TODO Auto-generated method stub
		houseRenterDAO.save(houseRenter);
	}

}
