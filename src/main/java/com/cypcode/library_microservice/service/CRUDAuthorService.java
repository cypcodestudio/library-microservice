package com.cypcode.library_microservice.service;

import com.cypcode.library_microservice.domain.Author;
import com.cypcode.library_microservice.domain.dto.AuthorDTO;

public interface CRUDAuthorService {
	AuthorDTO save(Author entity);
	AuthorDTO retrieveById(long id);
	void deleteById(long id);
}
