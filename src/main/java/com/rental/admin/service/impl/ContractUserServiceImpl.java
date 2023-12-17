package com.rental.admin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.admin.dao.ContractUserDAO;
import com.rental.admin.domain.ContractUser;
import com.rental.admin.domain.House;
import com.rental.admin.service.ContractUserService;

@Service
public class ContractUserServiceImpl implements ContractUserService{

	@Autowired
	private ContractUserDAO contractUserDAO;
	
	@Override
	public List<ContractUser> findAll() {
		// TODO Auto-generated method stub
		return contractUserDAO.findAll();
	}

	@Override
	public Optional<ContractUser> findById(Integer id) {
		// TODO Auto-generated method stub
		return contractUserDAO.findById(id);
	}

	@Override
	public List<ContractUser> findByHouse(House house) {
		// TODO Auto-generated method stub
		return contractUserDAO.findByHouse(house);
	}

}
