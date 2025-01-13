package com.cypcode.library_microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cypcode.library_microservice.domain.Book;
import com.cypcode.library_microservice.domain.dto.BookDTO;
import com.cypcode.library_microservice.service.CRUDBookService;

@RestController
@RequestMapping("book")
public class BookController {
	
	@Autowired
	private CRUDBookService bookServiceImpl;

	@PostMapping
	public ResponseEntity<?> createBook(@RequestBody BookDTO request){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(bookServiceImpl.save(request));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PutMapping
	public ResponseEntity<?> updateBook(@RequestBody BookDTO request){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(bookServiceImpl.save(request));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity<?> getAllBooks(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(bookServiceImpl.retrieveAll());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("filter")
	public ResponseEntity<?> getBook(@RequestParam(name = "title", required = false) String title,
			@RequestParam(name = "id", required = false) long id){
		try {
			if(Long.valueOf(id) != null) {
				return ResponseEntity.status(HttpStatus.OK).body(bookServiceImpl.retrieveById(id));	
			}
			
			if(title != null) {
				return ResponseEntity.status(HttpStatus.OK).body(bookServiceImpl.retrieveByTitle(title));
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Book Title or ID was provided, please provide book title or id to retrieve.");
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteBook(@RequestParam(name = "title", required = false) String title,
			@RequestParam(name = "id", required = false) long id){
		try {
			
			
			if(Long.valueOf(id) != null) {
				bookServiceImpl.deleteById(id);
				return ResponseEntity.status(HttpStatus.OK).build();	
			}
			
			if(title != null) {
				bookServiceImpl.deleteByTitle(title);
				return ResponseEntity.status(HttpStatus.OK).build();
			}

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Book Title or ID was provided, please provide book title or id to remove.");
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
}
