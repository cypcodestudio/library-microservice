package com.cypcode.library_microservice.service;

import com.cypcode.library_microservice.domain.Category;
import com.cypcode.library_microservice.domain.dto.CategoryDTO;

public interface CRUDCategoryService {
	CategoryDTO save(Category entity);
	CategoryDTO retrieveById(long id);
	void deleteById(long id);
}
