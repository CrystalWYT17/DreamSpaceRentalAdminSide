package com.rental.admin.service;

import java.util.List;
import java.util.Optional;

import com.rental.admin.domain.ContractUser;
import com.rental.admin.domain.House;

public interface ContractUserService {
	
	List<ContractUser> findAll();
	
	Optional<ContractUser> findById(Integer id);
	
	List<ContractUser> findByHouse(House house);

}
