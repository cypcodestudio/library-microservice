package com.cypcode.library_microservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cypcode.library_microservice.domain.Book;
import com.cypcode.library_microservice.persistance.IBookRepository;
import com.cypcode.library_microservice.service.CRUDBookService;

@Service
public class BookServiceImpl implements CRUDBookService{
	
	@Autowired
	private IBookRepository bookRepository;

	@Override
	public Book save(Book entity) {
		return bookRepository.save(entity);
	}

	@Override
	public Book retrieveById(long id) {
		return bookRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(long id) {
		bookRepository.deleteById(id);
	}

	@Override
	public List<Book> retrieveAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book retrieveByTitle(String title) {
		return bookRepository.findByTitle(title);
	}

	@Override
	public void deleteByTitle(String title) {
		bookRepository.deleteByTitle(title);
	}

}
