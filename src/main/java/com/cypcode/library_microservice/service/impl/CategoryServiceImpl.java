package com.cypcode.library_microservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cypcode.library_microservice.domain.Category;
import com.cypcode.library_microservice.domain.dto.CategoryDTO;
import com.cypcode.library_microservice.persistance.ICategoryRepository;
import com.cypcode.library_microservice.service.CRUDCategoryService;

@Service
public class CategoryServiceImpl implements CRUDCategoryService{

	@Autowired
	private ICategoryRepository categoryRepository;
	

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public CategoryDTO save(Category entity) {
		return modelMapper.map(categoryRepository.save(entity), CategoryDTO.class);
	}

	@Override
	public CategoryDTO retrieveById(long id) {
		return modelMapper.map(categoryRepository.findById(id).orElse(null), CategoryDTO.class);
	}

	@Override
	public void deleteById(long id) {
		categoryRepository.deleteById(id);
	}

}
