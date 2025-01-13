package com.cypcode.library_microservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cypcode.library_microservice.domain.Shelf;
import com.cypcode.library_microservice.domain.dto.ShelfDTO;
import com.cypcode.library_microservice.persistance.IShelfRepository;
import com.cypcode.library_microservice.service.CRUDShelfService;

@Service
public class ShelfServiceImpl implements CRUDShelfService{

	@Autowired
	private IShelfRepository shelfRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public ShelfDTO save(Shelf entity) {
		return modelMapper.map(entity, ShelfDTO.class);
	}

	@Override
	public ShelfDTO retrieveById(long id) {
		return modelMapper.map(shelfRepository.findById(id).orElse(null), ShelfDTO.class);
	}

	@Override
	public void deleteById(long id) {
		shelfRepository.deleteById(id);
	}

}
