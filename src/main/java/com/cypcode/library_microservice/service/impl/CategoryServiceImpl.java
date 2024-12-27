package com.cypcode.library_microservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cypcode.library_microservice.domain.Category;
import com.cypcode.library_microservice.persistance.ICategoryRepository;
import com.cypcode.library_microservice.service.CRUDCategoryService;

@Service
public class CategoryServiceImpl implements CRUDCategoryService{

	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Override
	public Category save(Category entity) {
		return categoryRepository.save(entity);
	}

	@Override
	public Category retrieveById(long id) {
		return categoryRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(long id) {
		categoryRepository.deleteById(id);
	}

}
