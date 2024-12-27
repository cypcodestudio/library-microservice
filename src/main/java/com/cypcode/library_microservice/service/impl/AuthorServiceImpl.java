package com.cypcode.library_microservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cypcode.library_microservice.domain.Author;
import com.cypcode.library_microservice.persistance.IAuthorRepository;
import com.cypcode.library_microservice.service.CRUDAuthorService;

@Service
public class AuthorServiceImpl implements CRUDAuthorService{

	@Autowired
	private IAuthorRepository authorRepository;
	
	@Override
	public Author save(Author entity) {
		return authorRepository.save(entity);
	}

	@Override
	public Author retrieveById(long id) {
		return authorRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(long id) {
		authorRepository.deleteById(id);
	}

}
