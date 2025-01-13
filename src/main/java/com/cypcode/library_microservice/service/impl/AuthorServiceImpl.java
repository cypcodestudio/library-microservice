package com.cypcode.library_microservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cypcode.library_microservice.domain.Author;
import com.cypcode.library_microservice.domain.dto.AuthorDTO;
import com.cypcode.library_microservice.persistance.IAuthorRepository;
import com.cypcode.library_microservice.service.CRUDAuthorService;

@Service
public class AuthorServiceImpl implements CRUDAuthorService{

	@Autowired
	private IAuthorRepository authorRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	
	@Override
	public AuthorDTO save(Author entity) {
		return modelMapper.map(authorRepository.save(entity), AuthorDTO.class);
	}

	@Override
	public AuthorDTO retrieveById(long id) {
		return modelMapper.map(authorRepository.findById(id).orElse(null), AuthorDTO.class);
	}

	@Override
	public void deleteById(long id) {
		authorRepository.deleteById(id);
	}

}
