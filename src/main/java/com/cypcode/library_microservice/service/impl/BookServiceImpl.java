package com.cypcode.library_microservice.service.impl;

import java.util.List;
import java.util.stream.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cypcode.library_microservice.domain.Author;
import com.cypcode.library_microservice.domain.Book;
import com.cypcode.library_microservice.domain.Category;
import com.cypcode.library_microservice.domain.dto.AuthorDTO;
import com.cypcode.library_microservice.domain.dto.BookDTO;
import com.cypcode.library_microservice.domain.dto.CategoryDTO;
import com.cypcode.library_microservice.persistance.IBookRepository;
import com.cypcode.library_microservice.service.CRUDBookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookServiceImpl implements CRUDBookService{
	
	@Autowired
	private IBookRepository bookRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public BookDTO save(BookDTO dto) {
		try {
			Book entity =  	modelMapper.map(dto, Book.class);
			return mapBookEntityToBookDTO(bookRepository.save(entity));		
		}catch(Exception e) {
			log.error("Failed to save book with title: {}", dto.getTitle());
			e.printStackTrace();
		}
		return null;
	}

	private List<BookDTO> mapBookEntityListToBookDTOList(List<Book> books) {
		if(!books.isEmpty())
			return books.stream().map(this::mapBookEntityToBookDTO).toList();	
		
		return null;
	}


	private BookDTO mapBookEntityToBookDTO(Book book) {
		if(book != null)
			return modelMapper.map(book, BookDTO.class);
		
		return null;
	}
	
	@Override
	public BookDTO retrieveById(long id) {
		return mapBookEntityToBookDTO(bookRepository.findById(id).orElse(null));
	}

	@Override
	public void deleteById(long id) {
		bookRepository.deleteById(id);
	}

	@Override
	public List<BookDTO> retrieveAll() {
		return mapBookEntityListToBookDTOList(bookRepository.findAll());
	}

	@Override
	public BookDTO retrieveByTitle(String title) {
		return mapBookEntityToBookDTO(bookRepository.findByTitle(title));
	}

	@Override
	public void deleteByTitle(String title) {
		bookRepository.deleteByTitle(title);
	}

}
