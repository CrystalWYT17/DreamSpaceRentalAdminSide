package com.rental.admin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.admin.dao.ContractDAO;
import com.rental.admin.dao.ContractUserDAO;
import com.rental.admin.domain.Contract;
import com.rental.admin.domain.ContractUser;
import com.rental.admin.domain.User;
import com.rental.admin.service.ContractService;

@Service
public class ContractServiceImpl implements ContractService{
	
	@Autowired
	private ContractDAO contractDAO;
	
	@Autowired
	private ContractUserDAO contractUserDAO;

	@Override
	public Contract save(Contract contract) {
		// TODO Auto-generated method stub
		return contractDAO.save(contract);
	}

	@Override
	public void saveContractUser(ContractUser contractUser) {
		// TODO Auto-generated method stub
		contractUserDAO.save(contractUser);
	}

	@Override
	public List<Contract> findAll() {
		// TODO Auto-generated method stub
		return  contractDAO.findAll();
	}

	@Override
	public Contract findByContractId(Long contractId) {
		// TODO Auto-generated method stub
		return contractDAO.findByContractId(contractId);
	}

	

	@Override
	public void deleteById(Long contractId, ContractUser contractUser) {
		// TODO Auto-generated method stub
		contractUserDAO.save(contractUser);
		contractDAO.deleteById(contractId);
	}

	@Override
	public List<ContractUser> findByUser(User user) {
		// TODO Auto-generated method stub
		return contractUserDAO.findByUser(user);
	}


}
