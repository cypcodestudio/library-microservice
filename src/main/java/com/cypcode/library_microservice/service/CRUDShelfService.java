package com.cypcode.library_microservice.service;

import com.cypcode.library_microservice.domain.Shelf;
import com.cypcode.library_microservice.domain.dto.ShelfDTO;

public interface CRUDShelfService {
	ShelfDTO save(Shelf entity);
	ShelfDTO retrieveById(long id);
	void deleteById(long id);

}
