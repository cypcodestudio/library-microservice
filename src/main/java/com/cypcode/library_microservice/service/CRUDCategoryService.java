package com.cypcode.library_microservice.service;

import com.cypcode.library_microservice.domain.Category;

public interface CRUDCategoryService {
	Category save(Category entity);
	Category retrieveById(long id);
	void deleteById(long id);
}
