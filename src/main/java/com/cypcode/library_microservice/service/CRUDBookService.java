package com.cypcode.library_microservice.service;

import java.util.List;

import com.cypcode.library_microservice.domain.Book;

public interface CRUDBookService {
	Book save(Book entity);
	Book retrieveById(long id);
	Book retrieveByTitle(String title);
	List<Book> retrieveAll();
	void deleteById(long id);
	void deleteByTitle(String title);
}
