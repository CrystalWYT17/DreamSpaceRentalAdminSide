package com.rental.admin.service;

import java.util.List;

import com.rental.admin.domain.Type;

public interface TypeService {

	Type saveType(Type type);
	
	List<Type> findAll();
	
	void removeOne(Long typeId);
	
	Type findById(Long typeId);
	
	
	Type findByTypeName(String typeName);
	
}
