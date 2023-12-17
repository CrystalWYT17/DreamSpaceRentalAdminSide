package com.rental.admin.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rental.admin.domain.Contract;

public interface ContractDAO extends CrudRepository<Contract, Long>{
	
	Contract findByContractId(Long contractId);
	
	List<Contract> findAll();

}
