package com.cypcode.library_microservice.service;

import java.util.List;

import com.cypcode.library_microservice.domain.Book;
import com.cypcode.library_microservice.domain.dto.BookDTO;

public interface CRUDBookService {
	BookDTO save(BookDTO entity);
	BookDTO retrieveById(long id);
	BookDTO retrieveByTitle(String title);
	List<BookDTO> retrieveAll();
	void deleteById(long id);
	void deleteByTitle(String title);
}
