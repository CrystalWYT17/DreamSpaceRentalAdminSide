package com.rental.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.admin.dao.HouseAgentSampleDAO;
import com.rental.admin.domain.HouseAgentSample;
import com.rental.admin.service.HouseAgentSampleService;

@Service
public class HouseAgentSampleServiceImpl implements HouseAgentSampleService{

	@Autowired
	private HouseAgentSampleDAO houseAgentSampleDAO;
	
	@Override
	public List<HouseAgentSample> findAll() {
		// TODO Auto-generated method stub
		return (List<HouseAgentSample>) houseAgentSampleDAO.findAll();
	}

	@Override
	public void save(HouseAgentSample hs) {
		// TODO Auto-generated method stub
		houseAgentSampleDAO.save(hs);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		houseAgentSampleDAO.deleteById(id);
	}

	@Override
	public HouseAgentSample findByHouseId(Long houseId) {
		// TODO Auto-generated method stub
		return houseAgentSampleDAO.findByHouseId(houseId);
	}

}
