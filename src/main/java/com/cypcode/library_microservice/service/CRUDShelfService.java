package com.cypcode.library_microservice.service;

import com.cypcode.library_microservice.domain.Shelf;

public interface CRUDShelfService {
	Shelf save(Shelf entity);
	Shelf retrieveById(long id);
	void deleteById(long id);

}
