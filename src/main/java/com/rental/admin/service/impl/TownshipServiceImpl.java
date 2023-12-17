package com.rental.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.admin.dao.TownshipDAO;
import com.rental.admin.domain.Township;
import com.rental.admin.service.TownshipService;

@Service
public class TownshipServiceImpl implements TownshipService {

	@Autowired
	private TownshipDAO townshipDAO;
	
	@Override
	public Township save(Township township) {
		// TODO Auto-generated method stub
		return townshipDAO.save(township);
	}

	@Override
	public List<Township> findAll() {
		// TODO Auto-generated method stub
		return townshipDAO.findAll();
	}

	@Override
	public Township findById(Integer townshipId) {
		// TODO Auto-generated method stub
		return townshipDAO.findById(townshipId).get();
	}

	@Override
	public void removeOne(Integer townshipId) {
		// TODO Auto-generated method stub
		townshipDAO.deleteById(townshipId);
	}

	@Override
	public Township update(Township township) {
		// TODO Auto-generated method stub
		townshipDAO.save(township);

		return township;
	}

	@Override
	public Township findByTownshipName(String townshipName) {
		// TODO Auto-generated method stub
		return townshipDAO.findByTownshipName(townshipName);
	}

}
