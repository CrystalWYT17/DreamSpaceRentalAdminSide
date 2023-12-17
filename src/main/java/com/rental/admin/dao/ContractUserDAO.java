package com.rental.admin.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rental.admin.domain.ContractUser;
import com.rental.admin.domain.House;
import com.rental.admin.domain.User;

public interface ContractUserDAO extends CrudRepository<ContractUser, Integer>{

	Optional<ContractUser> findById(Integer id);
	
	List<ContractUser> findByUser(User user);
	
	List<ContractUser> findAll();
	
	List<ContractUser> findByHouse(House house);
	
}
