package com.cypcode.library_microservice.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cypcode.library_microservice.domain.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long>{
	Book findByTitle(String title);
	void deleteByTitle(String title);

}
