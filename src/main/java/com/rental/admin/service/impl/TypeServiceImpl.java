package com.rental.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.admin.dao.TypeDAO;
import com.rental.admin.domain.Type;
import com.rental.admin.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService{

	@Autowired
	private TypeDAO typeDAO;
	
	@Override
	public List<Type> findAll() {
		// TODO Auto-generated method stub
		return typeDAO.findAll();
	}

	@Override
	public void removeOne(Long typeId) {
		// TODO Auto-generated method stub
		typeDAO.deleteById(typeId);
	}

	@Override
	public Type findById(Long typeId) {
		// TODO Auto-generated method stub
		return typeDAO.findById(typeId).get();
	}

	@Override
	public Type findByTypeName(String typeName) {
		// TODO Auto-generated method stub

		return typeDAO.findByTypeName(typeName);
	}

	@Override
	public Type saveType(Type type) {
		// TODO Auto-generated method stub
		return typeDAO.save(type);
	}
	
	

}
