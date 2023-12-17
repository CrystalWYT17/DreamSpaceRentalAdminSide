package com.rental.admin.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rental.admin.domain.Type;

public interface TypeDAO extends CrudRepository<Type, Long>{

	List<Type> findAll();
	
	Type findByTypeName(String typeName);


    //Type findById(Long typeId);

//void removeOne(Long typeId);

	
}
