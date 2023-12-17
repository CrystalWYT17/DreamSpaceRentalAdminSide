package com.rental.admin.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.admin.dao.HouseAgentDAO;
import com.rental.admin.dao.HouseDAO;
import com.rental.admin.dao.HouseImageDAO;
import com.rental.admin.dao.HouseOwnerDAO;
import com.rental.admin.dao.HouseRenterDAO;
import com.rental.admin.domain.House;
import com.rental.admin.domain.HouseAgent;
import com.rental.admin.domain.HouseImage;
import com.rental.admin.domain.HouseOwner;
import com.rental.admin.domain.HouseRenter;
import com.rental.admin.service.HouseService;

@Service
public class HouseServiceImpl implements HouseService{
	
	@Autowired
	private HouseDAO houseDAO;
	
	@Autowired
	private HouseImageDAO houseImageDAO;
	
	@Autowired
	private HouseOwnerDAO houseOwnerDAO;
	
	@Autowired
	private HouseRenterDAO houseRenterDAO;

	@Override
	public House findById(Long houseId) {
		// TODO Auto-generated method stub
		return houseDAO.findById(houseId).get();
	}

	@Override
	public House saveHouse(House house,HouseOwner houseOwner) {
		// TODO Auto-generated method stub
		houseOwnerDAO.save(houseOwner);
		return houseDAO.save(house);
		
	}

	@Override
	public void saveHouseImage(House house, Set<HouseImage> houseImage) {
		// TODO Auto-generated method stub
		
		for(HouseImage hI: houseImage) {
			if(house.getHouseId().equals(hI.getHouse().getHouseId())) {
				houseImageDAO.save(hI);
			}
		}
		
	}

	@Override
	public List<House> findAll() {
		// TODO Auto-generated method stub
		return (List<House>) houseDAO.findAll();
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return (int) houseDAO.count();
	}

	@Override
	public void deleteHouseAgent(Long houseAgentId) {
		// TODO Auto-generated method stub
		//houseAgentDAO.deleteById(houseAgentId);
	}

	@Override
	public void saveHouseAgent(HouseAgent houseAgent) {
		// TODO Auto-generated method stub
		
		//houseAgentDAO.save(houseAgent);
		
	}

	@Override
	public House findByAddress(String address) {
		// TODO Auto-generated method stub
		return houseDAO.findByAddress(address);
	}

	@Override
	public void saveHouseRenter(HouseRenter houseRenter) {
		// TODO Auto-generated method stub
		houseRenterDAO.save(houseRenter);
	}

	@Override
	public void deleteHouseRenter(HouseRenter houseRenter) {
		// TODO Auto-generated method stub
		houseRenterDAO.delete(houseRenter);;
	}

	@Override
	public List<HouseImage> findByHouse(House house) {
		// TODO Auto-generated method stub
		return houseImageDAO.findByHouse(house);
	}

	@Override
	public void saveHouseOwner(HouseOwner houseOwner) {
		// TODO Auto-generated method stub
		houseOwnerDAO.save(houseOwner);
	}

	@Override
	public void delete(House house) {
		// TODO Auto-generated method stub
		houseDAO.delete(house);
	}




		

}
