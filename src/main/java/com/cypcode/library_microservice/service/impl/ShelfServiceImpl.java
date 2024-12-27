package com.cypcode.library_microservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cypcode.library_microservice.domain.Shelf;
import com.cypcode.library_microservice.persistance.IShelfRepository;
import com.cypcode.library_microservice.service.CRUDShelfService;

@Service
public class ShelfServiceImpl implements CRUDShelfService{

	@Autowired
	private IShelfRepository shelfRepository;
	
	@Override
	public Shelf save(Shelf entity) {
		return shelfRepository.save(entity);
	}

	@Override
	public Shelf retrieveById(long id) {
		return shelfRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(long id) {
		shelfRepository.deleteById(id);
	}

}
