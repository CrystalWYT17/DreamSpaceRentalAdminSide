package com.rental.admin.service;

import java.util.List;
import java.util.Optional;

import com.rental.admin.domain.Contract;
import com.rental.admin.domain.ContractUser;
import com.rental.admin.domain.User;

public interface ContractService {
	
	Contract save(Contract contract);
	
	Contract findByContractId(Long contractId);
	
	void saveContractUser(ContractUser contractUser);
	
	List<Contract> findAll();
	
	
	void deleteById(Long contractId,ContractUser contractUser);
	
	List<ContractUser> findByUser(User user);

}
