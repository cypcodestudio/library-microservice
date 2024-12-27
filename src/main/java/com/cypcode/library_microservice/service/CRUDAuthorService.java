package com.cypcode.library_microservice.service;

import com.cypcode.library_microservice.domain.Author;

public interface CRUDAuthorService {
	Author save(Author entity);
	Author retrieveById(long id);
	void deleteById(long id);
}
